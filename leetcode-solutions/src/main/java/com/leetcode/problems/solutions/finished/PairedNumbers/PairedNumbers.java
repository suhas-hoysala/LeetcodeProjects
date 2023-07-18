package com.leetcode.problems.solutions.finished.PairedNumbers;
import java.util.*;
public class PairedNumbers {

    public static void main(String[] args) {
        int[] arr = {-6,2,-6,4,-3,8,3,2,-2,6,1,-3,-4,-4,-8,4};
        new Solution().canReorderDoubled(arr);
    }
    
}

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        boolean[] paired = new boolean[arr.length];
        int pairedCount = 0;
        Map<Integer, Set<Integer>> hashMap = new HashMap<Integer,  Set<Integer>>();
        for(int i = 0; i < arr.length; i++) {
            Integer x = arr[i];
            if(!hashMap.containsKey(x)) {
                hashMap.put(x, new HashSet<Integer>(Arrays.asList(new Integer[] {i})));
            }
            else {
                hashMap.get(x).add(i);
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(hashMap.containsKey(arr[i]*2)) {
                for(int index: hashMap.get(arr[i]*2)) {
                    if(index == 5)
                        System.out.print("");
                    if(index != i && !paired[index] && !paired[i]) {
                        paired[index] = true;
                        paired[i] = true;
                        pairedCount += 2;
                        break;
                    }
                }
            }
        }
        if(pairedCount == arr.length)
            return true;
        
        return false;
    }
}
