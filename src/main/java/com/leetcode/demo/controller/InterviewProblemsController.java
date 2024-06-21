package com.leetcode.demo.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/interviewquestions/")
public class InterviewProblemsController {
    @GetMapping("google/1")
    public ResponseEntity<String> getFilledTemplate(){
        return ResponseEntity.ok().body("Hello");
    }
}
