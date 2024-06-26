package com.leetcode.demo.controller;

import com.leetcode.demo.model.GoogleTemplateData;
import com.leetcode.demo.service.SolutionService;
import com.leetcode.demo.service.impl.DefaultSolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/interviewquestions/")
public class InterviewProblemsController {
    @Autowired
    DefaultSolutionService solutionService;
    @GetMapping("google/1")
    public ResponseEntity<String> getFilledTemplate(@RequestBody GoogleTemplateData templateData){
        //TODO: some validation for the templateData
        return ResponseEntity.ok().body(solutionService.fillTemplate(templateData));
    }
}
