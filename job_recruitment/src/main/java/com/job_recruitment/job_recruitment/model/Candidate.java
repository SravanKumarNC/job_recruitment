package com.job_recruitment.job_recruitment.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    private Long id;
    private String firstName;
    private String lastName;
    private String resume;
    private String status;
    private String rating;
    private String jobOpenings;
    private String hiringManager;
    private String email;
    private boolean backgroundCheck;
    private String source;
    private String reasonForRejection;
    private LocalDateTime lastUpdated = LocalDateTime.now();
    private LocalDateTime createdAt = LocalDateTime.now();
    private String updatedBy;
    private String createdBy;
}
