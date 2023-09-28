package com.Abdul.VotingApp.dtos;

import com.Abdul.VotingApp.entities.Candidate;
import com.Abdul.VotingApp.entities.Voters;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VotersDto
{
    private long voterId;

    private String VoterName;
    private String AdhaarcardNo;
    private String Address;
    private String consituency;
    private CandidatesDto candidates;

}
