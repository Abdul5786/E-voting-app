package com.Abdul.VotingApp.services.serviceImpl;

import com.Abdul.VotingApp.dtos.CandidatesDto;
import com.Abdul.VotingApp.entities.Candidate;
import com.Abdul.VotingApp.entities.Election;
import com.Abdul.VotingApp.entities.Voters;
import com.Abdul.VotingApp.exception.ResourceNotFoundException;
import com.Abdul.VotingApp.repositories.CandidatesRepo;
import com.Abdul.VotingApp.repositories.ElectionRepo;
import com.Abdul.VotingApp.services.CandidateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService
{
    @Autowired
     CandidatesRepo candidatesRepo;
    @Autowired
    ElectionRepo electionRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public CandidatesDto AddCandidate(CandidatesDto candidatesDto, Long electionId)
    {
        Election election = electionRepo.findById(electionId).orElseThrow(()-> new ResourceNotFoundException("election","electionId",electionId));
//      System.out.println("object object object "+election);
        Candidate candidate = this.modelMapper.map(candidatesDto, Candidate.class);
        candidate.setElection(election);
        Candidate savedCandidates = candidatesRepo.save(candidate);
        return this.modelMapper.map(savedCandidates,CandidatesDto.class);
    }

    @Override
    public CandidatesDto getCandidateById(Long cadId)
    {
        Candidate candidate = candidatesRepo.findById(cadId).orElseThrow(() -> new ResourceNotFoundException("candidate", "with id", cadId));
        return  modelMapper.map(candidate,CandidatesDto.class);
    }

    @Override
    public List<CandidatesDto> getAllListOfCandidates()
    {
        List<Candidate> all = candidatesRepo.findAll();
        List<CandidatesDto> candidatesDtoList = all.stream().map(candidate -> modelMapper.map(candidate, CandidatesDto.class)).collect(Collectors.toList());
        return  candidatesDtoList;
    }

    @Override
    public String getResult(Long cadId1,Long cadId2)
    {
        Candidate candidate1 = candidatesRepo.findById(cadId1).orElseThrow(() -> new ResourceNotFoundException("cadId", "cadId", +cadId1));
        Candidate candidate2 = candidatesRepo.findById(cadId2).orElseThrow(() -> new ResourceNotFoundException("cadId", "cadId", +cadId2));
        List<Voters> votingListOfCandidates1 = candidate1.getVoters();
        List<Voters> votingListOfCandidates2 = candidate2.getVoters();
        if(votingListOfCandidates1.stream().count()>votingListOfCandidates2.stream().count())
        {
              return candidate1.getCandiDateName()+    "is win by  "  +votingListOfCandidates1.stream().count()+   "  votes";
        }
        else {
                return candidate2.getCandiDateName()+  "is win by  "  +votingListOfCandidates2.stream().count()+   "  votes";
             }
//
    }


}
