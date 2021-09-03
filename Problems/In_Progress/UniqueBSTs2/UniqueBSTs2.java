package Problems.In_Progress.UniqueBSTs2;
import Common.*;
import java.util.*;
import java.util.stream.Stream;
public class UniqueBSTs2 {
    public static void main(String[] args) {
        //System.out.println(new Solution().generateTrees(3));
        System.out.println(new Solution().generateTrees(new TreeNode(3)).length);
    }
}


class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        return null;
    }

    public TreeNode[] generateTrees(TreeNode root) {
        int n = root.val;
        if(n == 1)
            return new TreeNode[] {new TreeNode(1)};
        
        if(root.left != null)
            System.out.print("");
        
        TreeNode[][] perms = new TreeNode[4][];
        var perm1 = new TreeNode(new TreeNode(n-1), n, new TreeNode(n-2));
        var perm2 = new TreeNode(new TreeNode(n-1), n, null);
        var perm3 = new TreeNode(null, n, new TreeNode(n-1));
        var perm4 = new TreeNode(null, n, null);

        perms[0] = generateTrees(perm1);
        perms[1] = generateTrees(perm2);
        perms[2] = generateTrees(perm3);
        perms[3] = new TreeNode[] {perm4};

        return Stream.of(perms)
        .flatMap(Stream::of) 
        .toArray(TreeNode[]::new);
        
        
    }
}