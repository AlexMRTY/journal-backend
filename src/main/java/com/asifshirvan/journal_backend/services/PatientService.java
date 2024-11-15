package com.asifshirvan.journal_backend.services;

import com.asifshirvan.journal_backend.exceptions.JpaException;
import com.asifshirvan.journal_backend.exceptions.PatientAlreadyExistsException;
import com.asifshirvan.journal_backend.dto.PatientDTO;
import com.asifshirvan.journal_backend.exceptions.PatientNotFoundException;
import com.asifshirvan.journal_backend.mappers.PatientMapper;
import com.asifshirvan.journal_backend.models.Patient;
import com.asifshirvan.journal_backend.repositories.PatientRepository;
import com.asifshirvan.journal_backend.services.interfaces.IPatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.rmi.UnexpectedException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PatientService implements IPatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper = PatientMapper.INSTANCE;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Get all the patients in the database.
     *
     * @return List of all patients.
     */
    public List<PatientDTO> getAllPatients() {
        try {
            return patientRepository.findAll().stream()
                    .map(patientMapper::patientToPatientDTO)
                    .collect(Collectors.toList());
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            log.error("JPA system error: " + e.getMessage(), e);
            throw new JpaException("An error occurred while fetching patients.");
        }
    }

    /**
     * Get a patient by Personal Number.
     *
     * @param personalNumber The personal number of the patient.
     * @return The patient with the given personal number.
     */
    public PatientDTO getPatientByPersonalNumber(String personalNumber) {
        try {
            Patient patient = patientRepository.findByPersonalNumber(personalNumber)
                    .orElseThrow(() -> {
                        log.warn("Patient with personal number " + personalNumber + " not found.");
                        return new PatientNotFoundException("Patient with personal number " + personalNumber + " not found.");
                    });
            return patientMapper.patientToPatientDTO(patient);
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            log.error("JPA system error: " + e.getMessage(), e);
            throw new JpaException("An error occurred while fetching patient.");
        }
    }

    /**
     * Create a new patient.
     *
     * @param patient The patient to be created. No id is required.
     * @return The created patient.
     */
    public PatientDTO createPatient(PatientDTO patient) {
        // Look if the patient already exists

        try {
            if (patientRepository.existsByPersonalNumber(patient.getPersonalNumber())) {
                log.warn("Patient with personal number " + patient.getPersonalNumber() + " already exists.");
                throw new PatientAlreadyExistsException("Patient with personal number " + patient.getPersonalNumber() + " already exists.");
            }
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            log.error("JPA system error: " + e.getMessage(), e);
            throw new JpaException("An error occurred while creating patient.");
        }

        return savePatient(patient);
    }

    /**
     * Update a patient.
     *
     * @param patient The patient to be updated. The id is required.
     * @return The updated patient.
     */
    public PatientDTO updatePatient(PatientDTO patient) {
        // Look if the patient exists
        try {
            Patient existingPatient = patientRepository.findById(patient.getId())
                    .orElseThrow(() -> {
                        log.warn("Patient with id " + patient.getId() + " not found.");
                        return new PatientNotFoundException("Patient with id " + patient.getId() + " not found.");
                    });
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            log.error("JPA system error: " + e.getMessage(), e);
            throw new JpaException("An error occurred while updating patient.");
        }

        return savePatient(patient);
    }

    /**
     * Delete a patient.
     * @param id The id of the patient to be deleted.
     */
    public boolean deletePatient(Long id) {
        try {
            if (!patientRepository.existsById(id)) {
                log.warn("Patient with id " + id + " not found.");
                throw new PatientNotFoundException("Patient with id " + id + " not found.");
            }
            patientRepository.deleteById(id);
            return true;
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            log.warn("JPA system error: " + e.getMessage(), e);
            throw new JpaException("An error occurred while deleting patient.");
        }
    }

    /**
     * save the patient to the database.
     * @param patient
     * @return
     */
    private PatientDTO savePatient(PatientDTO patient) {
        try {
            Patient updatedPatient = patientRepository.save(patientMapper.patientDTOToPatient(patient));
            return patientMapper.patientToPatientDTO(updatedPatient);
        } catch (DataIntegrityViolationException e) {
            // Handle unique constraint violations or other data integrity issues
            log.warn("Data integrity violation: " + e.getMessage(), e);
            throw new JpaException("An error occurred while saving patient.");
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            log.error("JPA system error: " + e.getMessage(), e);
            throw new JpaException("An error occurred while saving patient.");
        }
    }
}