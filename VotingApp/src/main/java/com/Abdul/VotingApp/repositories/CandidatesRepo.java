package com.Abdul.VotingApp.repositories;
import com.Abdul.VotingApp.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesRepo extends JpaRepository<Candidate,Long>
{
}
