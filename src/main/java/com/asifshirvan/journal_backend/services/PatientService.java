package com.asifshirvan.journal_backend.services;

import com.asifshirvan.journal_backend.dtos.PatientDTO;
import com.asifshirvan.journal_backend.mappers.PatientMapper;
import com.asifshirvan.journal_backend.models.Patient;
import com.asifshirvan.journal_backend.repositories.PatientRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

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
            throw new RuntimeException("JPA system error: " + e.getMessage(), e);
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
                    .orElseThrow(() -> new RuntimeException("Patient with personal number " + personalNumber + " not found."));
            return patientMapper.patientToPatientDTO(patient);
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            throw new RuntimeException("JPA system error: " + e.getMessage(), e);
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
                throw new RuntimeException("Patient with personal number " + patient.getPersonalNumber() + " already exists.");
            }
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            throw new RuntimeException("JPA system error: " + e.getMessage(), e);
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
                    .orElseThrow(() -> new RuntimeException("Patient with id " + patient.getId() + " not found."));
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            throw new RuntimeException("JPA system error: " + e.getMessage(), e);
        }

        return savePatient(patient);
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
            throw new RuntimeException("Data integrity violation: " + e.getMessage(), e);
        } catch (JpaSystemException e) {
            // Handle JPA system exceptions
            throw new RuntimeException("JPA system error: " + e.getMessage(), e);
        }
    }
}