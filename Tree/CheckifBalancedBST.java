/*
Given a binary tree, determine if it is 
height-balanced
.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */
public class CheckifBalancedBST {
    // Time Complexity Top down approach - O(N^2)
    // private int getHeight(TreeNode node) {
    //     if (node == null) {
    //         return 0; 
    //     }

    //     int leftHeight = getHeight(node.left);
    //     int rightHeight = getHeight(node.right);

    //     return Math.max(leftHeight, rightHeight) + 1;
    // }
    // public boolean isBalanced(TreeNode root) {
    //     if (root == null) {
    //         return true;
    //     }

    //     int leftHeight = getHeight(root.left);
    //     int rightHeight = getHeight(root.right);

    //     if (Math.abs(leftHeight - rightHeight) > 1) {
    //         return false;
    //     }
    //     return isBalanced(root.left) && isBalanced(root.right);
    // }
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
    public boolean isBalanced(TreeNode root) {
        return isBalancedBottomUp(root) != -1;
    }

    private int isBalancedBottomUp(TreeNode node) {
        if (node == null) {
            return 0; // Height of an empty tree is 0
        }

        // Recursively check left and right subtrees
        int leftHeight = isBalancedBottomUp(node.left);
        int rightHeight = isBalancedBottomUp(node.right);

        // Check if subtrees are unbalanced
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Unbalanced subtree
        }

        // Return height of the current node (including itself)
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(4);
        System.out.println(new CheckifBalancedBST().isBalanced(root));
        root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(4);
        root.right.right.left=new TreeNode(5);
        System.out.println(new CheckifBalancedBST().isBalanced(root));
    }
}
