package com.asifshirvan.journal_backend.models;


import com.asifshirvan.journal_backend.enums.Gender;
import com.asifshirvan.journal_backend.enums.MaritalStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NonNull
@Entity(name = "Patient")
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "patient_phone_unique",
                        columnNames = "phone"
                ),
                @UniqueConstraint(
                        name = "patient_personal_number_unique",
                        columnNames = "personal_number"
                )
        }
)
public class Patient {

    @Id
    @GeneratedValue()
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String personalNumber;
    private String phone;
    private LocalDate birthDate;
    private String address;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
}
















