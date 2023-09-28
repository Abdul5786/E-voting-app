package com.Abdul.VotingApp.controllers;

import com.Abdul.VotingApp.dtos.ElectionDtos;
import com.Abdul.VotingApp.entities.Election;
import com.Abdul.VotingApp.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/elections")
public class ElectionControllers
{
    @Autowired
    ElectionService electionService;


    @PostMapping(value = "/addElection")
    public ResponseEntity<ElectionDtos> addElection(@RequestBody ElectionDtos electionDtos)
    {
        ElectionDtos electionDtos1 = electionService.AddElection(electionDtos);
        return ResponseEntity.ok(electionDtos1);

    }

//    public ResponseEntity<List<Election>> getAllElections()
//    {
//               electionService.
//    }

}
