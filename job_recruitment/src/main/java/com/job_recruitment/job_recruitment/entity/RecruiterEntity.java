package com.job_recruitment.job_recruitment.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "recruiter")
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @NotBlank(message = "Please Enter First Name")
    private String firstName;
    @NotBlank(message = "Please Enter Last Name")
    private String lastName;
    private String companyName;
    @NotBlank(message = "Please Enter Address")
    @Pattern(regexp ="^[0-9]{10}$", message = "Mobile no is not valid")
    private String mobile;
    @Email(message = "Please Enter a valid email address")
    @NotBlank(message = "Please Enter email address")
    private String email;
    @Size(min = 4, max = 20, message = "password must contain min 4 characters and max 20 characters")
    private String password;


}
