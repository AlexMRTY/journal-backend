package com.asifshirvan.journal_backend.services;

import com.asifshirvan.journal_backend.models.Practitioner;

import java.util.List;

public interface IPractitionerService {
    List<Practitioner> getAllPractitioners();
    Practitioner createPractitioner(Practitioner practitioner);
}
