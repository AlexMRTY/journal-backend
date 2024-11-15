package com.asifshirvan.journal_backend.models;


import com.asifshirvan.journal_backend.enums.Gender;
import com.asifshirvan.journal_backend.enums.Role;
import jakarta.persistence.*;
import lombok.*;


import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NonNull
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
    @GeneratedValue()
    private Long id;

    private boolean active;
    private String firstName;
    private String lastName;
    private String workEmail;
    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;
}
