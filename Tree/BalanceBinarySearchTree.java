/*
Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

 

Example 1:


Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
Example 2:


Input: root = [2,1,3]
Output: [2,1,3]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 105
 */

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private TreeNode createBalancedBST(List<Integer> inorder_array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(inorder_array.get(mid));
        node.left = createBalancedBST(inorder_array, start, mid - 1);
        node.right = createBalancedBST(inorder_array, mid + 1, end);
        return node;

    }

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);

    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder_array = new ArrayList<>();
        inorderTraversal(root, inorder_array);
        System.out.println(inorder_array);
        return createBalancedBST(inorder_array, 0, inorder_array.size() - 1);
    }
    public static void main(String[] args) {
        BalanceBinarySearchTree obj=new BalanceBinarySearchTree();
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.right=new TreeNode(3);
        root.right.right.right=new TreeNode(4);
        // root.right.right.right.right=new TreeNode(5);
        // root.right.right.right.right.right=new TreeNode(6);
        // root.right.right.right.right.right.right=new TreeNode(7);

        root=obj.balanceBST(root);
        List<Integer> arr=new ArrayList<>();
        obj.inorderTraversal(root, arr);
        System.out.println(arr);

        TreeNode root2=new TreeNode(2,new TreeNode(1),new TreeNode(3));
        root2=obj.balanceBST(root2);
        List<Integer> arr2=new ArrayList<>();
        obj.inorderTraversal(root2, arr2);
        System.out.println(arr2);

    }
    
}