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
        Practitioner practitioner = new Practitioner();
        practitioner.setFirstName("John");
        practitioner.setLastName("Doe");
        practitioner.setActive(true);
        practitioner.setAddress("123 Main St");
        practitioner.setGender(Gender.FEMALE);
        practitioner.setRole(Role.DOCTOR);
        practitioner.setWorkEmail("example@gmail.com");

        return practitionerService.createPractitioner(practitioner);
    }

}
