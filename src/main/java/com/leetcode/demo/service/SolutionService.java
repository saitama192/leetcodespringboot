package com.leetcode.demo.service;

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
}
