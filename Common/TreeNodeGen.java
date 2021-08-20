package LeetcodeProjects.Common;
import java.util.*;
public class TreeNodeGen<T> {
    public T val;
    public TreeNodeGen<T> left;
    public TreeNodeGen<T> right;


    Queue<TreeNodeGen<T>> q = new LinkedList<>();

    // Function to create a node
    // with 'value' as the data
    // stored in it.
    // Both the children of this
    // new TreeNode are initially null.

    void insertValue(TreeNodeGen<?> root, T value) {
        if(value == null) {
            return;
        }
        TreeNodeGen<T> node = new TreeNodeGen<T>(value);
        if (root == null)
            root = node;

        // The left child of the
        // current TreeNode is used
        // if it is available.
        else if (q.peek().left == null)
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

    }

    // This function mainly calls
    // insertValue() for all array
    // elements. All calls use same
    // queue.
    public TreeNodeGen<T> createTree(T arr[], TreeNodeGen<T> root) {
        for (int i = 0; i < arr.length; i++)
            insertValue(root, arr[i]);
        return root;
    }



    // This is used to verify
    // the logic.
    void levelOrder(TreeNodeGen<T> root) {
        if (root == null)
            return;
        Queue<TreeNodeGen<T>> n = new LinkedList<>();
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

        TreeNodeGen<T> treeNode = (TreeNodeGen<T>) o;

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
        return "TreeNode{" + "val=" + val.toString() + ", left=" + left + ", right=" + right + '}';
    }

    public TreeNodeGen(T value) {
        this.val = value;
    }

    public TreeNodeGen(TreeNodeGen<T> left, T val, TreeNodeGen<T> right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }

    
    public TreeNodeGen(T[] arr, TreeNodeGen<T> root) {
        this(arr, root, 0);
    }

    public TreeNodeGen(T[] arr, TreeNodeGen<T> root, int i) {
        if (i < arr.length && arr[i] != null) {
            TreeNodeGen<T> temp = new TreeNodeGen<T>(arr[i]);
            root = temp;
 
            // insert left child
            root.left = new TreeNodeGen<T>(arr, root.left,
                                             2 * i + 1);
 
            // insert right child
            root.right = new TreeNodeGen<T>(arr, root.right,
                                               2 * i + 2);
        }
    }
}
