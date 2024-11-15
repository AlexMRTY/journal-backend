package com.asifshirvan.journal_backend.repositories;

import com.asifshirvan.journal_backend.models.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
}
