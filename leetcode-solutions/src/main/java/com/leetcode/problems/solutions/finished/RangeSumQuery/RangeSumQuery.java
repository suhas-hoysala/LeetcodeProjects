package com.leetcode.problems.solutions.finished.RangeSumQuery;

import java.util.*;

public class RangeSumQuery {
    public static void main(String[] args) {
        var x = new NumArray(
                new int[] { -8261, 2300, -1429, 6274, 9650, -3267, 1414, -8102, 6251, -5979, -5291, -4616, -4703 });
                System.out.println(x.sumRange(0,8));
                System.out.println(x.sumRange(4,5));
                System.out.println(x.sumRange(9,11));
                System.out.println(x.sumRange(2,11));
                System.out.println(x.sumRange(0,12));
                System.out.println(x.sumRange(9,12));
                System.out.println(x.sumRange(2,5));
                System.out.println(x.sumRange(0,9));
                System.out.println(x.sumRange(5,9));
                System.out.println(x.sumRange(0,1));
                System.out.println(x.sumRange(12,12));
                System.out.println(x.sumRange(6,7));
                System.out.println(x.sumRange(5,8));
                System.out.println(x.sumRange(1,1));
                System.out.println(x.sumRange(6,7));
                System.out.println(x.sumRange(10,11));
                System.out.println(x.sumRange(11,12));
                System.out.println(x.sumRange(7,8));
                System.out.println(x.sumRange(4,11));
                System.out.println(x.sumRange(8,9));
                System.out.println(x.sumRange(4,11));
                System.out.println(x.sumRange(2,9));
                System.out.println(x.sumRange(2,6));
                System.out.println(x.sumRange(11,12));
                System.out.println(x.sumRange(5,8));
                System.out.println(x.sumRange(11,11));
                System.out.println(x.sumRange(1,9));
                System.out.println(x.sumRange(12,12));
                System.out.println(x.sumRange(10,10));
                System.out.println(x.sumRange(4,7));
                System.out.println(x.sumRange(12,12));
                System.out.println(x.sumRange(8,10));
                System.out.println(x.sumRange(7,9));
                System.out.println(x.sumRange(4,7));

    }
}

class NumArray {

    int[] nums;
    HashMap<Integer, TreeSet<Integer[]>> hm;

    public NumArray(int[] nums) {
        this.nums = nums;
        hm = new HashMap<Integer, TreeSet<Integer[]>>();
    }

    public int sumRange(int left, int right) {
        int sum = 0;

        if (hm.get(left) == null) {
            hm.put(left, new TreeSet<Integer[]>((a, b) -> a[0] < b[0] ? 1 : -1));
        }

        if (hm.get(right) == null) {
            hm.put(right, new TreeSet<Integer[]>((a, b) -> a[0] < b[0] ? 1 : -1));
        }

        Integer[] entry = hm.get(right).higher(new Integer[] { left, Integer.MIN_VALUE });
        if (entry != null && entry[0] == left) {
            return entry[1];
        }
        else if(entry != null && entry[0] > left) {
            int index = entry[0];
            Integer[] leftentry = hm.get(left).higher(new Integer[] { index, Integer.MIN_VALUE });
            if (leftentry != null && leftentry[0] == index) {
                sum = leftentry[1] + entry[1] - nums[entry[0]];
            }

            else {
                int partSum = getSum(left, entry[0]) - nums[entry[0]];
                sum = partSum + entry[1];
                hm.get(entry[0]).add(new Integer[] { left, partSum });
            }
        }

        else
            sum = getSum(left, right);

        hm.get(right).add(new Integer[] { left, sum });

        return sum;
    }

    public int getSum(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(left,right);
 */