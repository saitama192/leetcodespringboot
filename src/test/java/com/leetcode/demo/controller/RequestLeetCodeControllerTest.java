package com.leetcode.demo.controller;

import com.leetcode.demo.service.impl.DefaultSolutionService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(RequestLeetCodeController.class)
class RequestLeetCodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DefaultSolutionService solutionService;

    @Test
    void getHello() {
    }

    @Test
    void get3Sum() {
    }

    @Test
    void getSummaryRanges() {
    }

    @Test
    void getParanthesisValidation() {
    }

    @Test
    @Description("Checks for the Yes scenario in Palindrome")
    void checkPalindromeWithYes() throws Exception {
        int palindromeNumber = 121;

        when(solutionService.isPalindrome(palindromeNumber)).thenReturn(true);

        this.mockMvc.perform(get("/api/v1/leetcode/palindrome").param("number", String.valueOf(palindromeNumber)))
                .andExpect(status().isOk())
                .andExpect(content().string("Yes"));
    }

    @Test
    @Description("Checks for the No scenario in Palindrome")
    void checkPalindromeWithNo() throws Exception {
        int palindromeNumber = 1214;

        when(solutionService.isPalindrome(palindromeNumber)).thenReturn(false);

        this.mockMvc.perform(get("/api/v1/leetcode/palindrome").param("number", String.valueOf(palindromeNumber)))
                .andExpect(status().isOk())
                .andExpect(content().string("No"));
    }
}