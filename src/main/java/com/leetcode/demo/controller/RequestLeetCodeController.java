package com.leetcode.demo.controller;

import com.leetcode.demo.exception.InvalidInputException;
import com.leetcode.demo.service.impl.DefaultSolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/leetcode/")
public class RequestLeetCodeController {

    @Autowired
    DefaultSolutionService solutionService;

    @Value("${userrrr.name}")
    String user;

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

    @GetMapping("paranthesis")
    public ResponseEntity<String> getParanthesisValidation(@RequestBody String paranthesisString){
        if(paranthesisString.isEmpty()){
            throw new InvalidInputException("input is empty String");
        }
        else{
            String regex = "[^\\{\\}\\[\\]\\(\\)]";
            String cleandString = paranthesisString.replaceAll(regex, "");
            if(cleandString.length()!= paranthesisString.length()){
                throw new InvalidInputException("String contains characters other than { } [ ] ( )");
            }
            else{
                String result = solutionService.isValidParenthesis(paranthesisString) ? "valid" : "invalid";
                return ResponseEntity.ok().body("Input String is "+result);
            }
        }
    }

    @GetMapping("palindrome")
    public ResponseEntity<String> checkPalindrome(@RequestParam("number") int number){
        String result = solutionService.isPalindrome(number) ? "Yes" : "No";
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("happynumber")
    public ResponseEntity<String> checkHappyNumber(@RequestParam("number") int number){
        String result = "Number "+number+ (solutionService.isHappy(number) ? " is " : " is not ")+"happy";
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/jump")
    public ResponseEntity<String> canJump(@RequestBody int[] numbers) {
        String result = "Provided array "+Arrays.toString(numbers)+" can "+(solutionService.canJump(numbers) ? "jump " : "not jump");
        // Process the list
        return ResponseEntity.ok(result);
    }

    @GetMapping("/anagram")
    public ResponseEntity<String> isAnagram(
            @RequestParam String input1,
            @RequestParam String input2) {
        String result = solutionService.isAnagram(input1,input2) ? "valid anagrams" : "not valid anagrams";
        return ResponseEntity.ok("Received: " + input1 + " and " + input2+" are "+result);
    }

    @GetMapping("/wordpattern")
    public ResponseEntity<String> checkWordPattern(
            @RequestParam String input1,
            @RequestParam String input2) {
        String result = (solutionService.wordPattern(input1,input2) ? "follow" : "does not follow")+" word pattern";
        return ResponseEntity.ok("Received input: "+result);
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok(user);
    }

    @GetMapping("/groupAnagrams")
    public ResponseEntity<List<List<String>>> getGroupAnagrams(@RequestBody String[] strings){
        return ResponseEntity.ok(solutionService.groupAnagrams(strings));
    }

    @GetMapping("/maskeddetails")
    public ResponseEntity<String> getMaskedString(@RequestParam("input") String input){
        return ResponseEntity.ok(solutionService.maskString(input));
    }

    @GetMapping("/nextPerfectSquare")
    public ResponseEntity<Long> getNextPerfectSquare(@RequestParam("input") long input){
        return ResponseEntity.ok(solutionService.getNextSquareRoot(input));
    }

    @GetMapping("/sortedNumberString")
    public ResponseEntity<String> getSortedNumberString(@RequestParam("input") String words){
        return ResponseEntity.ok(solutionService.getSortedNumberString(words));
    }

}
