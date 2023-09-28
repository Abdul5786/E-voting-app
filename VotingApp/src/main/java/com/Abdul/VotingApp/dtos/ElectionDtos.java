package com.Abdul.VotingApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElectionDtos
{
    private long electId;
    private Date addedDate;
    private String electionName;
}
