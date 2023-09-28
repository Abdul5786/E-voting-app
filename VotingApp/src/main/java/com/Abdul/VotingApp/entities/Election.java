package com.Abdul.VotingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="election_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Election
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long electId;
    private Date addedDate;
    private String electionName;

    @OneToMany(mappedBy = "election" ,cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<Candidate> candidates = new ArrayList<>();


}
