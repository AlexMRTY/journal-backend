package com.asifshirvan.journal_backend.enums;

public enum ConditionClinicalStatus {
    Active,             // The condition is currently active.
    Inactive,           // The condition is no longer active but might reoccur.
    Resolved,           // The condition has been resolved or cured.
    Relapsed,           // The condition has returned after a period of improvement.
    unknown             // Source does not know which of the status values currently applies for this condition
}
