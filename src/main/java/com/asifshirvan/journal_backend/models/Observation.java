package com.asifshirvan.journal_backend.models;


import com.asifshirvan.journal_backend.enums.ObservationCategory;
import com.asifshirvan.journal_backend.enums.ObservationStatus;
import jakarta.persistence.*;

import java.sql.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Table(name = "observation")
@Entity(name = "Observation")
public class Observation {

    @Id
    @SequenceGenerator(
            name = "observation_sequence",
            sequenceName = "observation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "observation_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private ObservationStatus status;

    @Column(
            name = "category",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private ObservationCategory category;

    @Column(
            name = "measurement",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String measurement;

    @ManyToOne
    @JoinColumn(
            name = "patient_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Patient patientId;

    @ManyToOne
    @JoinColumn(
            name = "encounter",
            referencedColumnName = "id",
            nullable = false
    )
    private Encounter encounter;

    @Column(
            name = "effective_date_time",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Date effectiveDateTime;

    @Column(
            name = "issued",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Date issued;

    @Convert(converter = UnitConverter.class)
    @Column(
            name = "value_quantity",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private ObservationValue valueQuantity;

    public Observation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObservationStatus getStatus() {
        return status;
    }

    public void setStatus(ObservationStatus status) {
        this.status = status;
    }

    public ObservationCategory getCategory() {
        return category;
    }

    public void setCategory(ObservationCategory category) {
        this.category = category;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public Patient getSubject() {
        return patientId;
    }

    public void setSubject(Patient subject) {
        this.patientId = subject;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public Date getEffectiveDateTime() {
        return effectiveDateTime;
    }

    public void setEffectiveDateTime(Date effectiveDateTime) {
        this.effectiveDateTime = effectiveDateTime;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public ObservationValue getValueQuantity() {
        return valueQuantity;
    }

    public void setValueQuantity(ObservationValue valueQuantity) {
        this.valueQuantity = valueQuantity;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "id=" + id +
                ", status=" + status +
                ", category=" + category +
                ", measurement='" + measurement + '\'' +
                ", subject=" + patientId +
                ", encounter=" + encounter +
                ", effectiveDateTime=" + effectiveDateTime +
                ", issued=" + issued +
                ", valueQuantity=" + valueQuantity +
                '}';
    }
}
