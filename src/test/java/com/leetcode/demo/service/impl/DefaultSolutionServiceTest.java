package com.leetcode.demo.service.impl;

import com.leetcode.demo.service.SolutionService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DefaultSolutionServiceTest {
    @InjectMocks
    private DefaultSolutionService solutionService;

    @Value("${demo.test.property}")
    private String testProperty1;

    @Test
    @Disabled
    void threeSum() {
    }

    @Test
    @Disabled
    void summaryRanges() {
    }

    @Test
    @Description("This test checks the valid string and ensures it gets correct result")
    void isValidParenthesis() {
        String validString = "{}[]()";
        boolean result = solutionService.isValidParenthesis(validString);
        Assert.isTrue(result, "passed");

    }
    @Test
    @Description("This test checks the invalid string and ensures it gets correct result")
    void isInValidParenthesis() {
        System.out.println(testProperty1);
        String validString = "{][]}()";
        boolean result = solutionService.isValidParenthesis(validString);
        Assert.isTrue(!result, "passed");

    }
}