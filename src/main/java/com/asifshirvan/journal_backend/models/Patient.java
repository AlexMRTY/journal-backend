package com.asifshirvan.journal_backend.models;


import com.asifshirvan.journal_backend.enums.Gender;
import com.asifshirvan.journal_backend.enums.MaritalStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

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
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "patient_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "gender",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Gender gender;

    @Column(
            name = "personal_number",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String personalNumber;

    @Column(
            name = "phone",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String phone;

    @Column(
            name = "birth_date",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private LocalDate birthDate;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "marital_status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private MaritalStatus maritalStatus;

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", personalNumber='" + personalNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", maritalStatus=" + maritalStatus +
                '}';
    }
}
















