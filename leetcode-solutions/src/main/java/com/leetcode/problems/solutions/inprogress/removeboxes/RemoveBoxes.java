package com.leetcode.problems.solutions.inprogress.removeboxes;
import com.leetcode.problems.commons.utils.*;
import java.util.Arrays;
public class RemoveBoxes {
    public static void main(String[] args) {
        
        Integer[] intList = ImportJson.getIntList("RemoveBoxes/list1.txt");
        int[] boxes = Arrays.stream(intList).mapToInt(Integer::intValue).toArray();

        System.out.println(new Solution().removeBoxes(boxes));
    }
}

class Solution {
    public int removeBoxes(int[] boxes) {
        int soln = 1;

        return soln;
    }
}