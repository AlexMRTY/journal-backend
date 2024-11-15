package com.asifshirvan.journal_backend.models;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "observation_values")
public class ObservationValue {
    @Id
    @SequenceGenerator(
            name = "observation_value_sequence",
            sequenceName = "observation_value_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "observation_value_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "value",
            nullable = false
    )
    private Float value;

    @Column(
            name = "unit",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Unit unit;
}
