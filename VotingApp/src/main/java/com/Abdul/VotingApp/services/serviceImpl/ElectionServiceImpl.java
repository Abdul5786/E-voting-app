package com.Abdul.VotingApp.services.serviceImpl;

import com.Abdul.VotingApp.dtos.ElectionDtos;
import com.Abdul.VotingApp.entities.Election;
import com.Abdul.VotingApp.exception.ResourceNotFoundException;
import com.Abdul.VotingApp.repositories.ElectionRepo;
import com.Abdul.VotingApp.services.ElectionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ElectionServiceImpl  implements ElectionService
{
    @Autowired
    ElectionRepo electionRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public ElectionDtos AddElection(ElectionDtos electionDtos)
    {
        Election election = this.modelMapper.map(electionDtos, Election.class);
        election.setAddedDate(new Date());
        Election savedElection = electionRepo.save(election);
        return this.modelMapper.map(savedElection,ElectionDtos.class);
    }

    @Override
    public ElectionDtos getElectionById(Long elecId)
    {
        Election election = electionRepo.findById(elecId).orElseThrow(() -> new ResourceNotFoundException("elecId", "id", +elecId));
        return this.modelMapper.map(election,ElectionDtos.class);
    }
}
