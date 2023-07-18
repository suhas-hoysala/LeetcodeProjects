package com.leetcode.problems.solutions.inprogress.rangeaddition2;
import com.leetcode.problems.commons.utils.*;

public class RangeAddition2 {
    public static void main(String[] args) {
        int[][] ops = ImportJson.intFromInt(ImportJson.getIntMatrix("RangeAddition2/ops1.txt"));
        System.out.println(new Solution().maxCount(3,3,ops));
    }
}

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int[][] mat = new int[m][n];
        for(int[] op: ops) {
            mat[op[0]][op[1]]++;
        }
        
        return 0;
    }
}