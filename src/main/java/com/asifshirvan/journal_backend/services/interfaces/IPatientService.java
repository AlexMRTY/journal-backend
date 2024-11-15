package com.asifshirvan.journal_backend.services.interfaces;

import com.asifshirvan.journal_backend.dto.PatientDTO;
import com.asifshirvan.journal_backend.models.Patient;

import java.util.List;

public interface IPatientService {
    List<PatientDTO> getAllPatients();
    PatientDTO createPatient(PatientDTO patient);
    PatientDTO getPatientByPersonalNumber(String personalNumber);
    PatientDTO updatePatient(PatientDTO patient);

    private PatientDTO savePatient(PatientDTO patient) {
        return null;
    }
    boolean deletePatient(Long id);
}
