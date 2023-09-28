package com.Abdul.VotingApp.repositories;
import com.Abdul.VotingApp.entities.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepo extends JpaRepository<Election,Long>
{
}
