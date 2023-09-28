package com.Abdul.VotingApp.services.serviceImpl;

import com.Abdul.VotingApp.dtos.VotersDto;
import com.Abdul.VotingApp.entities.Candidate;
import com.Abdul.VotingApp.entities.Voters;
import com.Abdul.VotingApp.exception.ResourceNotFoundException;
import com.Abdul.VotingApp.repositories.CandidatesRepo;
import com.Abdul.VotingApp.repositories.VotersRepo;
import com.Abdul.VotingApp.services.VotingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotingServiceImpl implements VotingService
{

    @Autowired
    CandidatesRepo candidatesRepo;

    @Autowired
    VotersRepo votersRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public VotersDto addVoter(VotersDto votersDto)
    {
        Voters voters = this.modelMapper.map(votersDto, Voters.class);
        System.out.println("voters info"+voters);
        votersRepo.save(voters);
        return this.modelMapper.map(voters,VotersDto.class);
    }

    @Override
    public VotersDto giveVoteToCandidates(Long voterId, Long candId)
    {
        Candidate candidate = candidatesRepo.findById(candId).orElseThrow();
        Voters voters = votersRepo.findById(voterId).orElseThrow();
        voters.setCandidate(candidate);
        Voters savedVotes = votersRepo.save(voters);
        return this.modelMapper.map(savedVotes,VotersDto.class);
    }

    @Override
    public VotersDto getVotersById(Long voterId)
    {
        Voters voters = votersRepo.findById(voterId).orElseThrow(() -> new ResourceNotFoundException("Voters", "votersId", voterId));
        return this.modelMapper.map(voters,VotersDto.class);
    }

    @Override
    public List<VotersDto> getAllVoters()
    {
        List<Voters> all = votersRepo.findAll();
        List<VotersDto> collect = all.stream().map(voters -> this.modelMapper.map(voters, VotersDto.class)).collect(Collectors.toList());
         return  collect;
    }
}
