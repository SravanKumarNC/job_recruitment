package com.job_recruitment.job_recruitment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {
    private Long Id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String mobile;
    private String email;
    private String password;
}
