package com.Abdul.VotingApp.controllers;

import com.Abdul.VotingApp.dtos.VotersDto;
import com.Abdul.VotingApp.entities.Voters;
import com.Abdul.VotingApp.services.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/voters")
public class VotingControllers
{
    @Autowired
    VotingService votingService;

    @PostMapping(value = "/addVoters")
    public ResponseEntity<VotersDto>  addVoters(@RequestBody VotersDto votersDto)
    {
        VotersDto votersDto1 = votingService.addVoter(votersDto);
        return ResponseEntity.ok(votersDto1);
    }

    @PostMapping("/voting/{voterId}/{cadId}")
    public ResponseEntity<VotersDto> voting(@PathVariable Long voterId,@PathVariable  Long cadId)
    {
        VotersDto votersDto = votingService.giveVoteToCandidates(voterId, cadId);
        return  ResponseEntity.ok(votersDto);
    }
    @GetMapping(value = "/getVoterById/{voterId}")
     public ResponseEntity<VotersDto> getVotersById(@PathVariable Long voterId)
     {
         VotersDto votersById = votingService.getVotersById(voterId);
         return ResponseEntity.ok(votersById);
     }

     @GetMapping(value = "/getAllVoters")
     public ResponseEntity<List<VotersDto>> getAllVoters()
     {
         List<VotersDto> allVoters = votingService.getAllVoters();
         return ResponseEntity.ok(allVoters);
     }


}
