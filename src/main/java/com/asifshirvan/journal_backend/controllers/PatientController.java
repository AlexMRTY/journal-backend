package com.asifshirvan.journal_backend.controllers;


import com.asifshirvan.journal_backend.dto.PatientDTO;
import com.asifshirvan.journal_backend.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
    private final PatientService patientService;

    @Autowired
    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    @PreAuthorize("hasAuthority('DOCTOR')")
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping("/createPatient")
    public PatientDTO createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        return patientService.createPatient(patientDTO);
    }
}
