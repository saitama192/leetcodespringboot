package com.leetcode.demo.service.impl;

import com.leetcode.demo.service.SolutionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DefaultSolutionService implements SolutionService {
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        nums = Arrays.stream(nums).sorted().toArray();
        int firstPointer;
        int secondPointer;
        for(int i = 0; i < (nums.length - 2); i++){
            firstPointer = i+1;
            secondPointer = nums.length - 1;
            while(firstPointer < secondPointer){
                int sum = nums[i]+ nums[firstPointer] + nums[secondPointer];
                if(sum > 0){
                    secondPointer--;
                }
                else if(sum < 0){

                    firstPointer++;
                }
                else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[firstPointer]);
                    tempList.add(nums[secondPointer]);
                    solutions.add(tempList);
                    while (firstPointer < secondPointer && nums[firstPointer] == tempList.get(1)) firstPointer++;
                    while (firstPointer < secondPointer && nums[secondPointer] == tempList.get(2)) secondPointer--;
                    //add to the list
                }

                // Move pointer to next unique element
                while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
            }

        }
        return solutions;
    }

    @Override
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 1){
            result.add(nums[0]+"");
            return result;
        }
        //start traversing from left to right
        for(int i = 0; i < nums.length; i++){
            int firstElement = nums[i];
            while(i < nums.length-1 && (nums[i] + 1) == nums[i+1]){
                i++;
            }
            if(firstElement!= nums[i]){
                result.add(firstElement+"->"+nums[i]);
            }
            else{
                result.add(firstElement+"");
            }
            //keep checking the next element if it equals to the first one
        }

        return result;
    }

    @Override
    public boolean isValidParenthesis(String string) {
        Set<Character> openingParantheses = new HashSet<>();
        openingParantheses.add('(');
        openingParantheses.add('{');
        openingParantheses.add('[');
        Stack<Character> paranthesis = new Stack<>();
        for(char c: string.toCharArray()){
            if(openingParantheses.contains(c)){
                if(c == '(') {
                    paranthesis.push(')');
                }
                else if(c == '{') {
                    paranthesis.push('}');
                }
                else {
                    paranthesis.push(']');
                }
                //if it is opening bracket push its reverse into the stack
            }
            else{
                if(paranthesis.isEmpty() || !(paranthesis.pop() == c)) //if it is closing bracket check if the pop the stack and compare it
                {
                    return false;
                }
            }//if it matches move ahead
        }
        return paranthesis.isEmpty();
    }

    @Override
    public boolean isPalindrome(int number) {
        //reverse the number
        int num = number; //keep a copy of x in this variable which we will be modifying
        int reverse = 0; //variable for storing reverse number
        while (num > 0) {     //we will be reversing one number at a time
            int temp = (int) num % 10; //extract the last number of the x
            reverse = reverse * 10 + temp; //multiply existing value in the reverse by shifting it to left and append the number to the right
            num = (int) num / 10; //reduce the length of temp num value by removing rightmost number
        }
        return reverse == number; //check if the reversed is matching with the first and return the boolean value
    }
}
