package com.leetcode.demo.service.impl;

import com.leetcode.demo.exception.InvalidInputException;
import com.leetcode.demo.model.GoogleTemplateData;
import com.leetcode.demo.service.SolutionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
                if(paranthesis.isEmpty() || (paranthesis.pop() != c)) //if it is closing bracket check if the pop the stack and compare it
                {
                    return false;
                }
            }//if it matches move ahead
        }
        return paranthesis.isEmpty();
    }

    @Override
    public String fillTemplate(GoogleTemplateData template) {
        String templateString = template.template();
        Map<String, String> data = template.data();
        StringBuilder result = new StringBuilder();
        int index = 0;
        int startVariable;
        int endVariable;
        boolean variableCheck = false;
        while(index < templateString.length()){
            if(templateString.charAt(index)=='$'){
                index++;
                startVariable = index;
                while(templateString.charAt(index)!='$'){
                    index++;
                }
                variableCheck = false;
                endVariable = index; //error
                String variable = templateString.substring(startVariable, endVariable);
                String value = getSimplifiedVariable(variable, data, null);
                if(data.containsKey(variable)){
                    result.append(value);  //error
                }
                else{
                    throw new InvalidInputException(String.format("Variable %s not found in the data", variable));
                }
            }
            else{
                result.append(templateString.charAt(index));
            }
            index++;
        }
        if(!variableCheck){
            return result.toString();
        }
        else throw new InvalidInputException("");
    }

    private String getSimplifiedVariable(String variable,Map<String, String> data, Set<String> checkedKeys) {
        //if the value contains a $ we need to check the data again
        if(checkedKeys == null){
            checkedKeys = new HashSet<>();
        }
        if(checkedKeys.contains(variable)){
            //we have already checked for this variable
            throw new InvalidInputException("Variable "+ variable+"value does not exist");
        }
        else{
        checkedKeys.add(variable);
        }
        String value = data.get(variable);
        if(value.charAt(0) == '$'){
            value = getSimplifiedVariable(variable, data, checkedKeys);
        }
        return value;
    }


    @Override
    public boolean isPalindrome(int number) {
        //reverse the number
        int num = number; //keep a copy of x in this variable which we will be modifying
        int reverse = 0; //variable for storing reverse number
        while (num > 0) {     //we will be reversing one number at a time
            int temp = num % 10; //extract the last number of the x
            reverse = reverse * 10 + temp; //multiply existing value in the reverse by shifting it to left and append the number to the right
            num = num / 10; //reduce the length of temp num value by removing rightmost number
        }
        return reverse == number; //check if the reversed is matching with the first and return the boolean value
    }

    @Override
    public boolean isHappy(int n) {
        int sum = makeSum(n);
        while (sum != 1 && sum != 4) {
            sum = makeSum(sum);
        }
        return sum == 1;
    }

    private int makeSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }

    @Override
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        Map<Character,String> charMap = new HashMap<>();
        Map<String,Character> wordMap = new HashMap<>();
        for(int i =0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];
            if (charMap.containsKey(c)) {
                String val = charMap.get(c);
                if (!val.equals(word)) {
                    return false;
                }
            } else {
                if (wordMap.containsKey(word) && wordMap.get(word) != c) {
                    return false;
                }
                charMap.put(c, word);
                wordMap.put(word, c);
            }
        }
        return true;
    }

    @Override
    public boolean canJump(int[] nums) {
        int position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > position) return false;
            position = Math.max(position, i + nums[i]);
        }
        return true;
    }

    @Override
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> characterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterMap.containsKey(c)) {
                int count = characterMap.get(c);
                characterMap.put(c, count + 1);
            } else {
                characterMap.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (characterMap.containsKey(c)) {
                int count = characterMap.get(c);
                if (count > 1) {
                    characterMap.put(c, count - 1);
                } else {
                    characterMap.remove(c);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String current = strs[i];
            //making a key out of the string
            String currentKey = current.chars()
                    .sorted()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining());
            if(anagramMap.containsKey(currentKey)){
                List<String> values =  anagramMap.get(currentKey);
                values.add(current);
            }
            else{
                List<String> values = new ArrayList<>();
                values.add(current);
                anagramMap.put(currentKey, values);
            }
        }
        return new ArrayList<>(anagramMap.values());
    }
}
