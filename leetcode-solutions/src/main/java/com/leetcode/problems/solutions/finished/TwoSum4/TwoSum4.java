package com.leetcode.problems.solutions.finished.TwoSum4;
import com.leetcode.problems.commons.utils.*;
import java.util.*;
public class TwoSum4 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new Integer[] {2, null, 3});
        System.out.println(root.toString());
        System.out.println(new Solution().findTarget(root, 6));
    }
}

class Solution {
    LinkedList<TreeNode> q = new LinkedList<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        TreeNode origNode = root;
        int searchVal =  k - root.val;
        
        if(root.left != null && findTarget(root.left, k, searchVal, origNode))
            return true;
        
        if(root.right != null && findTarget(root.right, k, searchVal, origNode))
            return true;
        
        q.add(root);
        
        if(findTarget(root.left, k))
            return true;

        if(findTarget(root.right, k))
            return true;
        
        for(TreeNode node: q) {
            if(findTarget(node, k, searchVal, origNode) && node != root) {
                return true;
            }
        }

        q.remove(root);
        return false;
    }

    public boolean findTarget(TreeNode root, int k, int searchVal, TreeNode origNode) {
        if(root.val == searchVal && root != origNode)
            return true;
        
        if(root.left != null && findTarget(root.left, k, searchVal, origNode))
            return true;
        
        if(root.right != null && findTarget(root.right, k, searchVal, origNode))
            return true;
        
        return false;
    }
}