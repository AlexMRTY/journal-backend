package com.asifshirvan.journal_backend.services;

import com.asifshirvan.journal_backend.models.Practitioner;
import com.asifshirvan.journal_backend.repositories.PractitionerRepository;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PractitionerService implements IPractitionerService {
    private final PractitionerRepository practitionerRepository;

    public PractitionerService(PractitionerRepository practitionerRepository) {
        this.practitionerRepository = practitionerRepository;
    }

    /**
     * Get all practitioners
     * @return List of practitioners
     */
    public List<Practitioner> getAllPractitioners() {
        try {
            List<Practitioner> practitioners = practitionerRepository.findAll();
            return practitioners;
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            throw new RuntimeException("JPA system error: " + e.getMessage(), e);
        }
    }

    /**
     * Create a practitioner
     * @param practitioner Practitioner to create
     * @return Created practitioner
     */
    public Practitioner createPractitioner(Practitioner practitioner) {
        return practitionerRepository.save(practitioner);
    }

}
