package com.leetcode.demo.service;

import com.leetcode.demo.model.GoogleTemplateData;

import java.util.List;

public interface SolutionService {
    /**
     * Finds all unique triplets in the given array {@code nums} that sum up to zero.
     *
     * @param nums An array of integers.
     * @return A list of lists where each inner list represents a unique triplet (a, b, c) such that a + b + c = 0.
     */
    public List<List<Integer>> threeSum(int[] nums);

    /**
     * Summarizes the ranges of consecutive numbers in the given array {@code nums}.
     *
     * @param nums An array of integers.
     * @return A list of strings representing the summarized ranges.
     */
    public List<String> summaryRanges(int[] nums);

    /**
     * Checks if the input String has valid parenthesis here we are checking the parenthesis in correct
     *
     * @param string a String with allowed integers
     * @return a boolean result
    **/
    public boolean isValidParenthesis(String string);

    /**
     * Checks if the input number is palindrome or not
     *
     * @param number to be checked for palindrome property
     * @return a boolean result
     * **/
    public boolean isPalindrome(int number);

    /**
     * Receives template Data with Template and Data and for the email and fills it
     *
     * @param template contains template and data
     * @return a string with filled email
     * **/
    public String fillTemplate(GoogleTemplateData template);
}
