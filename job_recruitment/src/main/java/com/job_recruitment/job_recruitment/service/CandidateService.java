package com.job_recruitment.job_recruitment.service;

import com.job_recruitment.job_recruitment.model.Candidate;
import com.job_recruitment.job_recruitment.model.Recruiter;

public interface CandidateService {
    public Candidate insertCandidate(Candidate candidate);

    public Candidate getCandidateById(Long id);

    public boolean deleteCandidate(Long id);

    public Candidate updateCandidate(Long id, Candidate candidate);

    Candidate getCandidateByEmail(String email);
}
