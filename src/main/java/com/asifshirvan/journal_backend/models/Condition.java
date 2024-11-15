package com.asifshirvan.journal_backend.models;

import com.asifshirvan.journal_backend.enums.ConditionClinicalStatus;
import com.asifshirvan.journal_backend.enums.ConditionVerificationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import static jakarta.persistence.GenerationType.SEQUENCE;

public class Condition {

    @Id
    @SequenceGenerator(
            name = "condition_sequence",
            sequenceName = "condition_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "condition_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "clinical_status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private ConditionClinicalStatus clinicalStatus;

    @Column(
            name = "verification_status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private ConditionVerificationStatus verificationStatus;

    @Column(
            name = "subject",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Patient subject;

    public Condition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConditionClinicalStatus getClinicalStatus() {
        return clinicalStatus;
    }

    public void setClinicalStatus(ConditionClinicalStatus clinicalStatus) {
        this.clinicalStatus = clinicalStatus;
    }

    public ConditionVerificationStatus getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(ConditionVerificationStatus verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Patient getSubject() {
        return subject;
    }

    public void setSubject(Patient subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "id=" + id +
                ", clinicalStatus=" + clinicalStatus +
                ", verificationStatus=" + verificationStatus +
                ", subject=" + subject +
                '}';
    }
}
