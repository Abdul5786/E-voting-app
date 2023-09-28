package com.Abdul.VotingApp.services;

import com.Abdul.VotingApp.dtos.CandidatesDto;
import com.Abdul.VotingApp.entities.Candidate;
import com.Abdul.VotingApp.entities.Voters;

import java.util.List;

public interface CandidateService
{
    CandidatesDto AddCandidate(CandidatesDto candidatesDto, Long ElectionId);
    CandidatesDto  getCandidateById(Long cadId);
    List<CandidatesDto> getAllListOfCandidates();
   String getResult(Long  cadId1,Long cadId2);
}
