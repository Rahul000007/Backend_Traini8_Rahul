package com.example.Traini.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Entity
@Data
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CenterName is required And Can't Be Empty")
    @Size(max = 40, message = "CenterName must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "CenterCode is required And Can't Be Empty")
    @Pattern(regexp = "[a-zA-Z0-9]{12}", message = "CenterCode must be exactly 12 characters alphanumeric")
    private String centerCode;

    @Embedded
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    private Instant createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "ContactPhone is required")
    @Pattern(regexp = "\\d{10}", message = "Invalid phone number format")
    private String contactPhone;
}



