package com.leetcode.problems.solutions.finished.LongestPalindrome;
public class Example {
    public static String newLongestPalindrome(String s, String substr, int i, int j) {
        String longestPalindrome = ""+substr;
        for(int x = 0; x < substr.length(); x++) {
            int y = 0;
            while(true) {
                int endIndex = 2*j - i - x + y;
                if(s.length() < endIndex)
                    break;
                String untilNonMatch = s.substring(i+x, j+y);
                String nextPart = s.substring(j+y, endIndex);
                System.out.println(untilNonMatch+" "+nextPart);
                String newPalindrome = untilNonMatch + nextPart;
                if(newPalindrome.equals(new StringBuilder(newPalindrome).reverse().toString())) {
                    if(newPalindrome.length() > longestPalindrome.length()) {
                        longestPalindrome = "" + newPalindrome;
                        j = 2*j - i;
                    }
                }
                y++;
            }
        }
        return longestPalindrome;
    }
    public static String longestPalindrome(String s) {
        String longestPalindrome = "";
        for(int i = 0; i < s.length(); i++) {
            int j = s.length();
            innerLoop: while(j > i) {
                String substr = s.substring(i, j);
                String substrReverse = new StringBuilder(substr).reverse().toString();
                if(substr.equals(substrReverse)) {
                    if(substr.length() > longestPalindrome.length()) {
                        longestPalindrome = newLongestPalindrome(s, substr, i, j);
                        i = j - 1;
                        break innerLoop;
                    }
                }
                j--;
            }
        }
            
        
        return longestPalindrome;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abacab"));
    }
}
