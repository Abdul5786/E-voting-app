package com.Abdul.VotingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="candidate_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Candidate
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long cadId;

    private String candiDateName;
    private String constituencyName;
    private String partyName;


    @ManyToOne
    private Election election;

    @OneToMany(mappedBy ="candidate" ,cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<Voters> voters = new ArrayList<>();
}
