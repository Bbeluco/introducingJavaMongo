package com.javaMongo.introducingJavaMongo.controllers;

import com.javaMongo.introducingJavaMongo.DTO.RemoveJobDTO;
import com.javaMongo.introducingJavaMongo.document.JobListDocument;
import com.javaMongo.introducingJavaMongo.repositories.EspecialSearchRepository;
import com.javaMongo.introducingJavaMongo.repositories.JobListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobListRepository jobListRepository;

    @Autowired
    private EspecialSearchRepository especialSearchRepository;

    @GetMapping("/")
    public ResponseEntity<List<JobListDocument>> getAllAvailableJobs(){
        return ResponseEntity.ok(jobListRepository.findAll());
    }

    @GetMapping("/{text}")
    public ResponseEntity<List<JobListDocument>> especialSearch(@PathVariable String text){
        return ResponseEntity.ok(especialSearchRepository.findByEspecial(text));
    }

    @PostMapping("/addJob")
    public ResponseEntity<JobListDocument> addJob(@RequestBody JobListDocument job){
        return ResponseEntity.status(201).body(jobListRepository.save(job));
    }

    @DeleteMapping("/removeJob")
    public ResponseEntity removeJob(@RequestBody RemoveJobDTO jobId){
        jobListRepository.deleteById(jobId.id());
        return ResponseEntity.ok("Job successfully removed");
    }
}
