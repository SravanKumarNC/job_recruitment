package com.job_recruitment.job_recruitment.repository;

import com.job_recruitment.job_recruitment.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Long> {
    CandidateEntity findByEmail(String email);
}
