package com.asifshirvan.journal_backend.models;


import com.asifshirvan.journal_backend.enums.Gender;
import com.asifshirvan.journal_backend.enums.Role;
import jakarta.persistence.*;


import static jakarta.persistence.GenerationType.SEQUENCE;


@Table(
        name = "practitioner",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "practitioner_work_email_unique",
                        columnNames = "work_email"
                )
        }
)
@Entity(
        name = "Practitioner"
)

public class Practitioner {
    @Id
    @SequenceGenerator(
            name = "practitioner_sequence",
            sequenceName = "practitioner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "practitioner_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "active",
            nullable = false
    )
    private boolean active;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "role",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Role role;

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

    @Column(
            name = "work_email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String workEmail;

    @Column(
            name = "address",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "gender",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Gender gender;

    public Practitioner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Practitioner{" +
                "id=" + id +
                ", active=" + active +
                ", role=" + role +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", workEmail='" + workEmail + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                '}';
    }
}
