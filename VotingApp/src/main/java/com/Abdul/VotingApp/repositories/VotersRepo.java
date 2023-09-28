package com.Abdul.VotingApp.repositories;

import com.Abdul.VotingApp.entities.Voters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotersRepo extends JpaRepository<Voters,Long>
{
}
