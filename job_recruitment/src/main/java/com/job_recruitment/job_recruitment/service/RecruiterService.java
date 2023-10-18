package com.job_recruitment.job_recruitment.service;

import com.job_recruitment.job_recruitment.entity.RecruiterEntity;
import com.job_recruitment.job_recruitment.model.Recruiter;

import java.util.List;

public interface RecruiterService {
    public Recruiter insertRecruiter(Recruiter recruiter);

    public Recruiter getRecruiterById(Long id);

    public boolean deleteRecruiter(Long id);

    public Recruiter updateRecruiter(Long id, Recruiter recruiter);

    Recruiter getRecruiterByEmail(String email);
}
