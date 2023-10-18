package com.job_recruitment.job_recruitment.serviceimpl;

import com.job_recruitment.job_recruitment.entity.CandidateEntity;
import com.job_recruitment.job_recruitment.model.Candidate;
import com.job_recruitment.job_recruitment.repository.CandidateRepository;
import com.job_recruitment.job_recruitment.service.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidateServiceImpl  implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public Candidate insertCandidate(Candidate candidate) {
        CandidateEntity candidateEntity = new CandidateEntity();
        candidateEntity.setId(candidate.getId());
        candidateEntity.setFirstName(candidate.getFirstName());
        candidateEntity.setLastName(candidate.getLastName());
        candidateEntity.setResume(candidate.getResume());
        candidateEntity.setStatus(candidate.getStatus());
        candidateEntity.setRating(candidate.getRating());
        candidateEntity.setSource(candidate.getSource());
        candidateEntity.setEmail(candidate.getEmail());
        candidateEntity.setBackgroundCheck(candidate.isBackgroundCheck());
        candidateEntity.setCreatedAt(candidate.getCreatedAt());
        candidateEntity.setCreatedBy(candidate.getCreatedBy());
        candidateEntity.setHiringManager(candidate.getHiringManager());
        candidateEntity.setJobOpenings(candidate.getJobOpenings());
        candidateEntity.setLastUpdated(candidate.getLastUpdated());
        candidateEntity.setUpdatedBy(candidate.getUpdatedBy());
        candidateEntity.setReasonForRejection(candidate.getReasonForRejection());

        candidateRepository.save(candidateEntity);

        return candidate;
    }

    @Override
    public Candidate getCandidateById(Long id) {
        CandidateEntity candidateEntity = candidateRepository.findById(id).get();
        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(candidateEntity,candidate);
        return candidate;
    }

    @Override
    public boolean deleteCandidate(Long id) {
        CandidateEntity candidateEntity = candidateRepository.findById(id).get();
        candidateRepository.delete(candidateEntity);
        return true;
    }

    @Override
    public Candidate updateCandidate(Long id, Candidate candidate) {
        CandidateEntity candidateEntity = candidateRepository.findById(id).get();
        candidateEntity.setId(candidate.getId());
        candidateEntity.setFirstName(candidate.getFirstName());
        candidateEntity.setLastName(candidate.getLastName());
        candidateEntity.setResume(candidate.getResume());
        candidateEntity.setStatus(candidate.getStatus());
        candidateEntity.setRating(candidate.getRating());
        candidateEntity.setSource(candidate.getSource());
        candidateEntity.setEmail(candidate.getEmail());
        candidateEntity.setBackgroundCheck(candidate.isBackgroundCheck());
        candidateEntity.setCreatedAt(candidate.getCreatedAt());
        candidateEntity.setCreatedBy(candidate.getCreatedBy());
        candidateEntity.setHiringManager(candidate.getHiringManager());
        candidateEntity.setJobOpenings(candidate.getJobOpenings());
        candidateEntity.setLastUpdated(candidate.getLastUpdated());
        candidateEntity.setUpdatedBy(candidate.getUpdatedBy());
        candidateEntity.setReasonForRejection(candidate.getReasonForRejection());
        candidateRepository.save(candidateEntity);

        return candidate;
    }

    @Override
    public Candidate getCandidateByEmail(String email) {
        CandidateEntity candidateEntity = candidateRepository.findByEmail(email);
        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(candidateEntity, candidate);
        return candidate;
    }
}
