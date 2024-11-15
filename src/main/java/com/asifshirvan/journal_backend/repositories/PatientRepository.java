package com.asifshirvan.journal_backend.repositories;


import com.asifshirvan.journal_backend.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsByPersonalNumber(String personalNumber);
    Optional<Patient> findByPersonalNumber(String personalNumber);
}
