import javax.swing.tree.TreeNode;

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
class Distribute_Coins_in_Binary_Tree {
   private int minmoves = 0;

   private int dfs(TreeNode root) {
      if (root == null)
         return 0;

      int leftCoin = dfs(root.left);
      int rightCoin = dfs(root.right);

      minmoves += Math.abs(leftCoin) + Math.abs(rightCoin);
      return root.val - 1 + leftCoin + rightCoin;
   }

   public int distributeCoins(TreeNode root) {
      dfs(root);
      return minmoves;
   }
}