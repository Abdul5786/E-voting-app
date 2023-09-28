package com.Abdul.VotingApp.services;

import com.Abdul.VotingApp.dtos.VotersDto;
import com.Abdul.VotingApp.entities.Voters;

import java.util.List;

public interface VotingService
{
   VotersDto addVoter(VotersDto votersDto);
   VotersDto giveVoteToCandidates(Long voterId,Long candId);

   VotersDto getVotersById(Long voterId);
   List<VotersDto> getAllVoters();


}
