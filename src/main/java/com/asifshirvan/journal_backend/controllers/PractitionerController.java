package com.asifshirvan.journal_backend.controllers;

import com.asifshirvan.journal_backend.enums.Gender;
import com.asifshirvan.journal_backend.enums.Role;
import com.asifshirvan.journal_backend.models.Practitioner;
import com.asifshirvan.journal_backend.repositories.PractitionerRepository;
import com.asifshirvan.journal_backend.services.IPractitionerService;
import com.asifshirvan.journal_backend.services.PractitionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PractitionerController {

    private final IPractitionerService practitionerService;

    @Autowired
    public PractitionerController(IPractitionerService practitionerService) {
        this.practitionerService = practitionerService;
    }

    @GetMapping("/practitioners")
    public List<Practitioner> getAllPractitioners() {
        return practitionerService.getAllPractitioners();
    }

    @GetMapping("/create-practitioner")
    public Practitioner createPractitioner() {
        Practitioner practitioner = Practitioner.builder()
                .active(true)
                .firstName("John")
                .lastName("Doe")
                .workEmail("johnDoe69@gmail.com")
                .address("Main street 69")
                .role(Role.DOCTOR)
                .build();
        return practitionerService.createPractitioner(practitioner);
    }

}
