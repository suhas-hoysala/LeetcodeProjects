package LeetcodeProjects.Problems.In_Progress.PathsSum2;
import java.util.*;
import LeetcodeProjects.Common.TreeNode;


public class PathsSum2 {

    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = new TreeNode(arr);
        System.out.println(root.toString());
        System.out.println(new Solution().pathSum(root, 22));
    }
    
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        if(root == null)
            return pathsList;
        
        int val = root.val;
        if(targetSum - val < 0)
            return pathsList;
        
        List<Integer> currPath = new ArrayList<Integer>();
        currPath.add(val);
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode[] nodes = new TreeNode[] {left, right};
        
        for(TreeNode node: nodes) {
            pathsList.addAll(pathSum(node, currPath, val, targetSum));
        }
        
        
        return pathsList;
    }
    
    public List<List<Integer>> pathSum(TreeNode root, List<Integer> currPath, int currSum, int targetSum) {
        List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
        if(root == null)
            return new ArrayList<List<Integer>>();
        
        int val = root.val;
        if(targetSum - (currSum+val) < 0)
            return new ArrayList<List<Integer>>();
        
        currPath.add(val);
        currSum += val;
        TreeNode[] nodes = new TreeNode[]{root.left, root.right}; 
        for(TreeNode node: nodes) {
            List<List<Integer>> partPathsList = pathSum(root.left, currPath, currSum, targetSum);
            if(partPathsList.size() == 0) {
                if(currSum == targetSum) {
                    pathsList.add(currPath);
                }
            }
            else {
                pathsList.addAll(partPathsList);
            }
        }
        
        return pathsList;
    }
}