package LeetcodeProjects.Common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    Queue<TreeNode> q = new LinkedList<>();

    // Function to create a node
    // with 'value' as the data
    // stored in it.
    // Both the children of this
    // new TreeNode are initially null.

    private boolean insertValue(Integer value, boolean prevInserted) {
        if(value == null) 
            return false;
        TreeNode node = new TreeNode(value);

        // The left child of the
        // current TreeNode is used
        // if it is available.

        if (q.peek().left == null && prevInserted)
            q.peek().left = node;

        // The right child of the current
        // TreeNode is used if it is available.
        // Since the left child of this
        // node has already been used, the
        // TreeNode is popped from the queue
        // after using its right child.
        else {
            q.peek().right = node;
            q.remove();
        }

        // Whenever a new TreeNode is added
        // to the tree, its address is
        // pushed into the queue. So that
        // its children Nodes can be used
        // later.
        q.add(node);
        return true;

    }

    // This function mainly calls
    // insertValue() for all array
    // elements. All calls use same
    // queue.
    public TreeNode(Integer arr[], String dum) {
        this(arr[0]);
        q.add(this);
        int i = 1;
        boolean inserted = true;
        while(i < arr.length) {
            inserted = insertValue(arr[i++], inserted);
        }
    }

    // This is used to verify
    // the logic.
    void levelOrder(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> n = new LinkedList<>();
        n.add(root);
        while (!n.isEmpty()) {
            System.out.print(n.peek().val + " ");
            if (n.peek().left != null)
                n.add(n.peek().left);
            if (n.peek().right != null)
                n.add(n.peek().right);
            n.remove();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TreeNode)) {
            return false;
        }

        TreeNode treeNode = (TreeNode) o;

        if (val != treeNode.val) {
            return false;
        }
        if (left != null ? !left.equals(treeNode.left) : treeNode.left != null) {
            return false;
        }
        return right != null ? right.equals(treeNode.right) : treeNode.right == null;
    }

    @Override
    public int hashCode() {
        int result = ((Object) val).hashCode();
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
    }

    public TreeNode(int value) {
        this.val = value;
    }

    public TreeNode(TreeNode left, int val, TreeNode right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }

    public TreeNode(Integer[] arr) {
        this(arr, null, 0);
    }

    private TreeNode(Integer[] arr, TreeNode root, int i) {
        this(arr[i]);
        root = this;

        // insert left child
        root.left = 2 * i + 1 < arr.length && arr[2 * i + 1] != null ? new TreeNode(arr, root.left, 2 * i + 1)
                : null;
        // insert right child
        root.right = 2 * i + 2 < arr.length && arr[2 * i + 2] != null ? new TreeNode(arr, root.right, 2 * i + 2)
                : null;
        
    }
}
