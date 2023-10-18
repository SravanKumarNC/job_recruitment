package com.job_recruitment.job_recruitment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "candidate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please Enter First Name")
    private String firstName;
    @NotBlank(message = "Please Enter Last Name")
    private String lastName;
    @NotBlank(message = "Please upload resume")
    private String resume;
    private String status;
    private String rating;
    private String jobOpenings;
    private String hiringManager;
    @Email(message = "Please Enter a valid email address")
    @NotBlank(message = "Please Enter email address")
    private String email;
    private boolean backgroundCheck;
    private String source;
    private String reasonForRejection;
    private LocalDateTime lastUpdated = LocalDateTime.now();
    private LocalDateTime createdAt = LocalDateTime.now();
    private String updatedBy;
    private String createdBy;
}
