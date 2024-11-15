package com.asifshirvan.journal_backend.repositories;

import com.asifshirvan.journal_backend.models.Practitioner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PractitionerRepository extends JpaRepository<Practitioner, Long> {
}
