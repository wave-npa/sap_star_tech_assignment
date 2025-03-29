package org.wave.sapstar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    // Task 1: Find Non-repeating character
    public static Character FindFirstNonRepeatChar(String input) {
        // Set up Hashmap to get character and the amount of time they appear in input string
        HashMap<Character, Integer> repeatChar = new HashMap<Character, Integer>();
        // Loop through all characters in string
        for (int i = 0; i < input.length(); i++) {
            // Add charcter to hashmap, if character first time appearance then integer will be 0 after that the amount increase by 1 for repeat cases
            repeatChar.put(input.charAt(i), repeatChar.getOrDefault(input.charAt(i), 0) + 1);
        }
        // Loop through all characters in string again to find the first non repeating character
        for (Character c : input.toCharArray()) {
            if (repeatChar.get(c) == 1) {
                // Return first non-repeating character
                return c;
            }
        }
        // If there is no non-repeating character, return null
        return null;
    }

    // Task 2: Count Occurences of each character in a string
    public static HashMap<Character, Integer> CountCharOccurences(String input) {
        // Set up Hashmap to get character and the amount of time they appear in input string
        HashMap<Character, Integer> occurCount = new HashMap<Character, Integer>();
        // Loop through all characters in string
        for (int i = 0; i < input.length(); i++) {
            // Add charcter to hashmap, if character first time appearance then integer will be 0 after that the amount increase by 1 for repeat cases
            occurCount.put(input.charAt(i), occurCount.getOrDefault(input.charAt(i), 0) + 1);
        }

        // Return Hashmap for occurences of each character in string
        return occurCount;
    }

    // Task 3: Merge Two Sorted Arrays
    public static ArrayList<Integer> MergeTwoSortedArray(int[] input1, int[] input2, ArrayList<Integer> result) {
        // Check if any input array is empty
        if (input1.length > 0 && input2.length > 0) {
            // Find lowest interger between 2 input array
            if (input1[0] < input2[0]) {
                result.add(input1[0]);
                // Remove first element of input array with the lowest interger
                input1 = Arrays.copyOfRange(input1, 1, input1.length);
                // Recursive loop to go through input array
                result = MergeTwoSortedArray(input1, input2, result);
            } else {
                result.add(input2[0]);
                // Remove first element of input array with the lowest interger
                input2 = Arrays.copyOfRange(input2, 1, input2.length);
                // Recursive loop to go through input array
                result = MergeTwoSortedArray(input1, input2, result);
            }
        } else {
            int count1 = 0;
            int count2 = 0;
            // Loop through the remaining interger in input1 array to add to result
            while (count1 < input1.length) {
                result.add(input1[count1]);
                count1++;
            }
            // Loop through the remaining interger in input2 array to add to result
            while (count2 < input2.length) {
                result.add(input2[count2]);
                count2++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String inputTask1 = "aabbcc"; // Change inputTask1 according to your test cases
        System.out.println("Task 1 - First non repeating character: " + FindFirstNonRepeatChar(inputTask1)); // Print result of task 1

        String inputTask2 = "aaabbbbcc"; // Change inputTask2 according to your test cases
        Integer count = 1;
        String task2Output = "Task 2 - All character occurences: {";
        // Get character occurences in hashmap
        HashMap<Character, Integer> occurences = CountCharOccurences(inputTask2);
        // Loop through hashmap keyset to format result to {a = 1, b = 2, c = 3} format
        for (Character c : occurences.keySet()) {
            String temp = c + "=" + occurences.get(c);
            task2Output = task2Output.concat(temp);
            // Check for the end of for loop
            if (count == occurences.keySet().size()) {
                // Close parentheses
                task2Output = task2Output.concat("}");
            } else {
                task2Output = task2Output.concat(", ");
            }
            count++;
        }
        System.out.println(task2Output); // Print result of task 2

        int input1Task3[] = new int[] { 1, 3, 5 }; // Change input1Task3 and input2Task3 according to your test cases
        int input2Task3[] = new int[] { 2, 4, 6 }; // Change input1Task3 and input2Task3 according to your test cases

        ArrayList<Integer> sortedResult = new ArrayList<Integer>();
        sortedResult = MergeTwoSortedArray(input1Task3, input2Task3, sortedResult);
        // Convert ArrayList to int[] for printing in log
        int[] result = sortedResult.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Task 3 - Merge 2 sorted arrays: " + Arrays.toString(result)); // Print result of task 3
    }
}