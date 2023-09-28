package com.Abdul.VotingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "voters_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Voters
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long voterId;

    private String VoterName;
    private String AdhaarcardNo;
    private String Address;
    private String consituency;

    @ManyToOne
    private Candidate candidate;

    @Override
    public String toString() {
        return "Voters{" +
                "voterId=" + voterId +
                ", VoterName='" + VoterName + '\'' +
                ", AdhaarcardNo='" + AdhaarcardNo + '\'' +
                ", Address='" + Address + '\'' +
                ", consituency='" + consituency + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}
