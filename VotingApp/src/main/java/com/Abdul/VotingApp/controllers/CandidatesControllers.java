package com.Abdul.VotingApp.controllers;

import com.Abdul.VotingApp.dtos.CandidatesDto;
import com.Abdul.VotingApp.entities.Candidate;
import com.Abdul.VotingApp.entities.Voters;
import com.Abdul.VotingApp.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesControllers
{
    @Autowired
    CandidateService candidateService;

    @PostMapping(value = "/addCandidate/election/{electionId}")
    public ResponseEntity<CandidatesDto>  AddCandidate(@RequestBody CandidatesDto candidatesDto, @PathVariable Long electionId)
    {
        CandidatesDto candidatesDto1 = candidateService.AddCandidate(candidatesDto, electionId);
        return ResponseEntity.ok(candidatesDto1);
    }
    @GetMapping("/getAllCandidates")
    public ResponseEntity<List<CandidatesDto>> getallCandidates()
    {
        List<CandidatesDto> allListOfCandidates = candidateService.getAllListOfCandidates();
        return ResponseEntity.ok(allListOfCandidates);
    }

    @GetMapping("/getResult/canidate1/{cadId1}/candidate2/{cadId2}")
    public String  getResult(@PathVariable Long cadId1, @PathVariable Long cadId2)
    {
        String result = candidateService.getResult(cadId1, cadId2);
        return result;
    }

}
