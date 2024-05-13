package com.leetcode.demo.controller;

import com.leetcode.demo.exception.InvalidInputException;
import com.leetcode.demo.service.SolutionService;
import com.leetcode.demo.service.impl.DefaultSolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leetcode/")
public class RequestLeetCodeController {

    @Autowired
    DefaultSolutionService solutionService;

    @GetMapping("hello")
    public ResponseEntity<String> getHello(){
        return ResponseEntity.ok().body("Hello");
    }

    @GetMapping("3sum")
    public ResponseEntity<List<List<Integer>>> get3Sum(@RequestBody List<Integer> numList){
        if(numList.size()< 3){
            throw new InvalidInputException("Input has less than three elements");
        }
        else{
            int[] nums =numList.stream().mapToInt(Integer::intValue).toArray();
            return ResponseEntity.ok().body(solutionService.threeSum(nums));
        }
    }

    @GetMapping("summaryranges")
    public ResponseEntity<List<String>> getSummaryRanges(@RequestBody List<Integer> numList){
        if(CollectionUtils.isEmpty(numList)){
            throw new InvalidInputException("Empty List");
        }
        else{
            int[] nums =numList.stream().sorted().distinct().mapToInt(Integer::intValue).toArray();
            return ResponseEntity.ok().body(solutionService.summaryRanges(nums));
        }
    }

}
