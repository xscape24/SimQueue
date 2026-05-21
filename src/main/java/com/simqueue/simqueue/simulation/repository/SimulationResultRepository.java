package com.simqueue.simqueue.simulation.repository;

// Fix: Import from your actual simulation model package instead of com.example
import com.simqueue.simqueue.simulation.model.SimulationResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulationResultRepository extends JpaRepository<SimulationResult, Long> {
    // JpaRepository gives us save(), findAll(), findById(), delete() automatically!
}