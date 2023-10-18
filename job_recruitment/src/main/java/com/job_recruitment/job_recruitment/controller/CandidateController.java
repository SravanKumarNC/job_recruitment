package com.job_recruitment.job_recruitment.controller;

import com.job_recruitment.job_recruitment.model.Candidate;
import com.job_recruitment.job_recruitment.service.CandidateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/candidates")
@AllArgsConstructor
@Validated
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping
    public ResponseEntity<?> insertCandidate(@Valid @RequestBody Candidate candidate, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        Candidate insertedCandidate = candidateService.insertCandidate(candidate);
        return ResponseEntity.ok(insertedCandidate);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Recruiter> getRecruiter(@PathVariable Long id){
//        Recruiter recruiter = new Recruiter();
//        recruiter = recruiterService.getRecruiterById(id);
//        return ResponseEntity.ok(recruiter);
//    }

    @GetMapping("/{email}")
    public ResponseEntity<Candidate> getCandidateByEmail(@PathVariable String email){
        Candidate candidate = candidateService.getCandidateByEmail(email);
        return ResponseEntity.ok(candidate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCandidate(@PathVariable Long id){
        boolean deleted = false;
        deleted = candidateService.deleteCandidate(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecruiter(@PathVariable Long id, @Valid @RequestBody Candidate candidate, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        candidate = candidateService.updateCandidate(id, candidate);
        return ResponseEntity.ok(candidate);
    }
}
