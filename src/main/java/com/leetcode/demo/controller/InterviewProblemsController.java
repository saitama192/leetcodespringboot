package com.leetcode.demo.controller;

import com.leetcode.demo.model.GoogleTemplateData;
import com.leetcode.demo.service.SolutionService;
import com.leetcode.demo.service.impl.DefaultSolutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/interviewquestions/")
@Tag(name = "Interview Questions", description = "Endpoints for interview question solutions")
public class InterviewProblemsController {
    @Autowired
    DefaultSolutionService solutionService;

    @Operation(summary = "Fill Google template", description = "Fill a template with provided data")
    @GetMapping("google/1")
    public ResponseEntity<String> getFilledTemplate(@RequestBody GoogleTemplateData templateData) {
        // TODO: some validation for the templateData
        return ResponseEntity.ok().body(solutionService.fillTemplate(templateData));
    }
}
