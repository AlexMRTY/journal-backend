package com.asifshirvan.journal_backend.repositories;

import com.asifshirvan.journal_backend.models.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncounterRepository extends JpaRepository<Encounter, Long> {
}
