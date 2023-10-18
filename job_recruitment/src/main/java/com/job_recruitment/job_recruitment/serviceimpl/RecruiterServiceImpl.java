package com.job_recruitment.job_recruitment.serviceimpl;

import com.job_recruitment.job_recruitment.entity.RecruiterEntity;
import com.job_recruitment.job_recruitment.model.Recruiter;
import com.job_recruitment.job_recruitment.repository.RecruiterRepository;
import com.job_recruitment.job_recruitment.service.RecruiterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    public RecruiterRepository recruiterRepository;

    @Override
    public Recruiter insertRecruiter(Recruiter recruiter) {
        RecruiterEntity recruiterEntity = new RecruiterEntity();
        recruiterEntity.setId(recruiter.getId());
        recruiterEntity.setFirstName(recruiter.getFirstName());
        recruiterEntity.setLastName(recruiter.getLastName());
        recruiterEntity.setCompanyName(recruiter.getCompanyName());
        recruiterEntity.setMobile(recruiter.getMobile());
        recruiterEntity.setEmail(recruiter.getEmail());
        recruiterEntity.setPassword(recruiter.getPassword());

        recruiterRepository.save(recruiterEntity);

        return recruiter;
    }

    @Override
    public Recruiter getRecruiterById(Long id) {
        RecruiterEntity recruiterEntity = recruiterRepository.findById(id).get();
        Recruiter recruiter = new Recruiter();
        BeanUtils.copyProperties(recruiterEntity, recruiter);
        return recruiter;
    }

    @Override
    public boolean deleteRecruiter(Long id) {
        RecruiterEntity recruiterEntity = recruiterRepository.findById(id).get();
        recruiterRepository.delete(recruiterEntity);
        return true;
    }

    @Override
    public Recruiter updateRecruiter(Long id, Recruiter recruiter) {
        RecruiterEntity recruiterEntity = recruiterRepository.findById(id).get();

        recruiterEntity.setFirstName(recruiter.getFirstName());
        recruiterEntity.setLastName(recruiter.getFirstName());
        recruiterEntity.setCompanyName(recruiter.getCompanyName());
        recruiterEntity.setMobile(recruiter.getMobile());
        recruiterRepository.save(recruiterEntity);
        return recruiter;
    }

    @Override
    public Recruiter getRecruiterByEmail(String email) {
        RecruiterEntity recruiterEntity = recruiterRepository.findByEmail(email);
        Recruiter recruiter = new Recruiter();
        BeanUtils.copyProperties(recruiterEntity, recruiter);

        return recruiter;
    }
}
