package com.Abdul.VotingApp.services;

import com.Abdul.VotingApp.dtos.ElectionDtos;
import com.Abdul.VotingApp.entities.Election;

public interface ElectionService
{
    ElectionDtos AddElection(ElectionDtos electionDtos);
    ElectionDtos getElectionById(Long elecId);
    // list of election


}
