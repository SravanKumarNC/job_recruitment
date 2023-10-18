package com.job_recruitment.job_recruitment.controller;

import com.job_recruitment.job_recruitment.model.Recruiter;
import com.job_recruitment.job_recruitment.service.RecruiterService;
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
@RequestMapping("/api/v1/recruiters")
@AllArgsConstructor
@Validated
public class RecruiterController {

    @Autowired
    RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<?> insertRecruiter(@Valid @RequestBody Recruiter recruiter, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        Recruiter insertedRecruiter = recruiterService.insertRecruiter(recruiter);
        return ResponseEntity.ok(insertedRecruiter);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Recruiter> getRecruiter(@PathVariable Long id){
//        Recruiter recruiter = new Recruiter();
//        recruiter = recruiterService.getRecruiterById(id);
//        return ResponseEntity.ok(recruiter);
//    }

    @GetMapping("/{email}")
    public ResponseEntity<Recruiter> getRecruiterByEmail(@PathVariable String email){
        Recruiter recruiter = recruiterService.getRecruiterByEmail(email);
        return ResponseEntity.ok(recruiter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRecruiter(@PathVariable Long id){
        boolean deleted = false;
        deleted = recruiterService.deleteRecruiter(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecruiter(@PathVariable Long id, @Valid @RequestBody Recruiter recruiter, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        recruiter = recruiterService.updateRecruiter(id, recruiter);
        return ResponseEntity.ok(recruiter);
    }
}
