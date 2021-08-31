package Problems.Solved.GoodNodes;
import Common.*;
public class GoodNodes {
    
    public static void main(String[] args) {
        Integer[] arr = {3,3,null,4,2};
        TreeNode root = new TreeNode(arr);
        System.out.println(new Solution().goodNodes(root));
        
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, 1, root.val);
    }
    
    public int goodNodes(TreeNode root, int count, int maxVal) {
        
        TreeNode left = root.left;
        if(left != null) {
            if(left.val >= maxVal)
                count++;
            count = goodNodes(left, count, Math.max(maxVal, left.val));
        }
        TreeNode right = root.right;
        
        if(right != null) {
            if(right.val >= maxVal)
                count++;
            count = goodNodes(right, count, Math.max(maxVal, right.val));
        }
        return count;
    }
}