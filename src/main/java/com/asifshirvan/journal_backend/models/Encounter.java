package com.asifshirvan.journal_backend.models;


import com.asifshirvan.journal_backend.enums.EncounterStatus;
import jakarta.persistence.*;

import java.sql.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Table(
        name = "encounter"
)
@Entity(name = "Encounter")
public class Encounter {
    @Id
    @SequenceGenerator(
            name = "encounter_sequence",
            sequenceName = "encounter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "encounter_sequence"
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
    private EncounterStatus status;

    @ManyToOne
    @JoinColumn(
            name = "patient_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "patient_encounter_fk"
            )
    )
    private Patient patient;

    @Column(
            name = "period_start",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Date periodStart;

    @Column(
            name = "period_end",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Date periodEnd;

    @ManyToOne
    @JoinColumn(
            name = "practitioner_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "practitioner_encounter_fk"
            )
    )
    private Practitioner practitioner;

    public Encounter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EncounterStatus getStatus() {
        return status;
    }

    public void setStatus(EncounterStatus status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Practitioner getPractitioner() {
        return practitioner;
    }

    public void setPractitioner(Practitioner practitionerId) {
        this.practitioner = practitionerId;
    }

    @Override
    public String toString() {
        return "Encounter{" +
                "id=" + id +
                ", status=" + status +
                ", subject='" + patient + '\'' +
                ", periodStart=" + periodStart +
                ", periodEnd=" + periodEnd +
                ", practitionerId=" + practitioner +
                '}';
    }
}
