package com.Abdul.VotingApp.dtos;

import com.Abdul.VotingApp.entities.Voters;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidatesDto
{
    private long cadId;
    private String candiDateName;
    private String constituencyName;
    private String partyName;
    private  ElectionDtos election;

}
