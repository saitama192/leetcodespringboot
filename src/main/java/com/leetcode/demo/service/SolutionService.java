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

    /**
     * Receives int and tells whether it is a happy integer or not
     * @param int n is a number to be checked
     * @return boolean result
     * */
    public boolean isHappy(int n);

    /**
     * Checks if the string is following a pattern specified
     * @param pattern is a string whose pattern we are checking against the String s
     * @return boolean result
     * */
    public boolean wordPattern(String pattern, String s);

    /**
     * Receives int[] array and based on the position of each value and tells
     * whether it is able to jump to last location or not
     * @param int[] nums is an array to be checked
     * @return boolean result
     * */
    public boolean canJump(int[] nums);
    /**
     * Checks if the given two strings are anagram or not
     * a word is considered to be an anagram of another word if the word can be constructed by using the
     * all letters of the target word, with same occurances of the letters available in target word
     * @param s is a string which wr are checking against the String t
     * @return boolean result
     * */
    public boolean isAnagram(String s, String t);
    /**
     * Groups an array of strings into lists of anagrams.
     *
     * <p>This method takes an array of strings and groups them into lists where each list contains
     * strings that are anagrams of each other. An anagram is a word or phrase formed by rearranging
     * the letters of a different word or phrase, typically using all the original letters exactly once.
     *
     * @param strs an array of strings to be grouped into anagrams
     * @return a list of lists, where each inner list contains strings that are anagrams of each other
     */
    public List<List<String>> groupAnagrams(String[] strs);

    /**
     * Masks an input string only leaving last 4 characters as it is
     *
     *if the string length is less than 4, then the string is not masked
     * @param input a string to be masked
     * @return a String which is masked
     */
    public String maskString(String input);


    /**
     * @param input gives supposed perfect square number
     * @return if the input is valid square number we provide the next perfect square root
     */
    public long getNextSquareRoot(long input);

    /**
     * @param words gives input String containing words in which each word has one digit from 1-9
     * @return return String with sorted input from 1-9 in order of the digits
     */
    public String getSortedNumberString(String words);
}
