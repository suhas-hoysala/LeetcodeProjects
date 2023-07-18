package com.leetcode.problems.solutions.inprogress.maxproductofsplittedbinarytree;

import com.leetcode.problems.commons.utils.*;

public class MaxProductOfSplittedBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        TreeNode root = new TreeNode (arr);
        System.out.println(root.toString());
        System.out.println(new Solution().maxProduct(root));

    }
}

class Solution {
    int largestProd = 1;
    int total_sum = 0;

    public int maxProduct(TreeNode root) {
        total_sum = getTotalSum(root);
        return 0;
    }

    private int[] maxProduct(TreeNode root, int currSum) {
        int[] myParts = new int[2];
        boolean wentLeft = true;
        if (wentLeft) {
            int leftProd = myParts[0] * myParts[1];
            int rightProd = (myParts[0] - root.val) * (myParts[1] + root.val);
            largestProd = Math.max(leftProd, rightProd) > largestProd ? Math.max(leftProd, rightProd) : largestProd;
            return myParts;
        }

        int rightProd = myParts[0] * myParts[1];
        int leftProd = (myParts[1] - root.val) * (myParts[0] + root.val);
        largestProd = Math.max(leftProd, rightProd) > largestProd ? Math.max(leftProd, rightProd) : largestProd;
        return myParts;
    }

    private int getTotalSum(TreeNode root) {

        int[] myParts = new int[2];
        
        if (root == null)
            return 0;

        if (root.left != null) {
            myParts[0] = root.val + getTotalSum(root.left);
            myParts[1] = root.right != null ? getTotalSum(root.right) : 0;
        }

        else if (root.right != null) {
            myParts[1] = root.val + getTotalSum(root.right);
            myParts[0] = 0;
        }

        else {
            return root.val;
        }

        return myParts[0] + myParts[1];
        
    }
}
