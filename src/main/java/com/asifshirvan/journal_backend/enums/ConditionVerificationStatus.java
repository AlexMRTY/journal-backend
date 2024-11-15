package com.asifshirvan.journal_backend.enums;

public enum ConditionVerificationStatus {
    Unconfirmed,            // Condition is suspected but not yet confirmed.
    Provisional,            // Initial diagnosis, pending further investigation.
    Differential,           // One of several possible diagnoses (requires further testing).
    Confirmed,              // Condition has been confirmed by diagnostic tests.
    Refuted,                // Condition has been ruled out after evaluation.
    EnteredInError          // The record was entered by mistake.
}
