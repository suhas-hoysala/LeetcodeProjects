package com.leetcode.problems.solutions.finished.ArrayNesting;
public class arrayNesting {
    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        System.out.println(new Solution().arrayNesting(nums));
    }
}

class Solution {
    public int arrayNesting(int[] nums) {
        int maxCount = 0;
        for(int startIndex = 0; startIndex < nums.length; startIndex++) {
            int currIndex = startIndex;
            int currCount = 0;
            while(true) {
                currCount++;
                currIndex = nums[currIndex];
                if(currIndex == startIndex) {
                    break;
                }
            }
            if(currCount > maxCount)
                maxCount = currCount;
        }
        return maxCount;
    }
    
}