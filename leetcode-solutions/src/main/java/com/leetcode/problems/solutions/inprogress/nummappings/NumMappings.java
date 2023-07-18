package com.leetcode.problems.solutions.inprogress.nummappings;

import java.util.*;

public class NumMappings {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("111111111111111111111111111111111111111111111"));
    }

}
class Solution {
    HashMap<String, Character> charMappings = new HashMap<>();
    Integer[] progress;

    public int numDecodings(String s) {
        for (char c = 48; c < 48 + 26; c++) {
            charMappings.put(Integer.toString(c - 47), c);
        }

        
        progress = new Integer[s.length()];

        return numDecodings(s, 0);
    }

    private int numDecodings(String s, int currIndex) {
        if (currIndex < s.length() && progress[currIndex] != null)
            return progress[currIndex];
        int count = 0;

        if (currIndex >= s.length())
            return ++count;
        if (currIndex < s.length() - 1) {
            if (charMappings.containsKey("" + s.charAt(currIndex) + s.charAt(currIndex + 1))) {
                count += numDecodings(s, currIndex + 2);
            }

        }
        if (charMappings.containsKey("" + s.charAt(currIndex))) {
            count += numDecodings(s, currIndex + 1);
        }

        progress[currIndex] = count;
        return count;
    }
}
