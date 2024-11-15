package com.asifshirvan.journal_backend.dto;

import com.asifshirvan.journal_backend.enums.Gender;
import com.asifshirvan.journal_backend.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@NonNull
@Builder
public class PractitionerDTO {

    private Long id;
    private boolean active;

    @Size(max = 50, message = "First name must be less than 50 characters")
    private String firstName;

    @Size(max = 50, message = "Last name must be less than 50 characters")
    private String lastName;

    private String workEmail;

    @Size(max = 100, message = "Address must be less than 100 characters")
    private String address;

    private Gender gender;
    private Role role;
}
