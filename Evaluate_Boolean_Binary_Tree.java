/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Evaluate_Boolean_Binary_Tree {
       public boolean evaluateTree(TreeNode root) {
              // postfix type evaluation of tree using DFS
              if (root.left == null && root.right == null) {
                     return root.val == 1;
              }
              boolean valLeft = evaluateTree(root.left);
              boolean valRight = evaluateTree(root.right);
              if (root.val == 2) { // OR
                     return valLeft || valRight;
              }
              // AND
              return valLeft && valRight;
       }
}