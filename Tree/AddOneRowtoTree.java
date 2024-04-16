/*
Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
 

Example 1:


Input: root = [4,2,6,3,1,5], val = 1, depth = 2
Output: [4,1,1,2,null,null,6,3,1,5]
Example 2:


Input: root = [4,2,null,3,1], val = 1, depth = 3
Output: [4,2,null,1,1,3,null,null,1]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
The depth of the tree is in the range [1, 104].
-100 <= Node.val <= 100
-105 <= val <= 105
1 <= depth <= the depth of tree + 1
 */

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree {
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode cur=new TreeNode(val,root,null);
            return cur;            
        }
        Queue<TreeNode> lastlevel=new LinkedList<>();
        lastlevel.add(root);
        int d=1;
        while(d<depth-1){
            Queue<TreeNode> queue=new LinkedList<>();
            while(!lastlevel.isEmpty()){
                TreeNode node=lastlevel.remove();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            d++;
                lastlevel=queue; 
                //updating last seen level queue so if d becomes depth we can append 
                //left right in all
        }
        while(!lastlevel.isEmpty()){            
            TreeNode node=lastlevel.remove();
            TreeNode newLeft = new TreeNode(val,node.left,null);
            TreeNode newRight = new TreeNode(val,null,node.right);
            node.left=newLeft;
            node.right=newRight;
        }
        lastlevel.clear();
        return root;
    }
    public static void main(String[] args) {
        AddOneRowtoTree solution = new AddOneRowtoTree();

        // Test case 1: [4,2,6,3,1,5] 1 2
        TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, null, new TreeNode(5)));
        printTree(root1);
        System.out.println();
        TreeNode result1 = solution.addOneRow(root1, 1, 2);        
        printTree(result1);
        System.out.println("\n");
        // Output: [4,1,1,2,null,null,6,3,1,5]

        // Test case 2: [4,2,null,3,1] 1 3
        TreeNode root2 = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), null);
        printTree(root2);
        System.out.println();
        TreeNode result2 = solution.addOneRow(root2, 1, 3);
        
        printTree(result2);
        System.out.println("\n");
        // Output: [4,2,null,1,1,3,1]

        // Test case 3: [4,2,6,3,1,5] 1 3
        TreeNode root3 = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, null, new TreeNode(5)));
        printTree(root3);
        System.out.println();
        TreeNode result3 = solution.addOneRow(root3, 1, 3);
        
        printTree(result3);
        System.out.println("\n");
        // Output: [4,2,6,1,1,1,1,3,1,5]

        // Test case 4: [4,2,6,1,1,1,1,1,null,null,1,1,null,null,1,1,null,null,1,1,null,null,1,3,null,null,1,5] 1 3
        TreeNode root4 = new TreeNode(4, new TreeNode(2, new TreeNode(1, new TreeNode(1), null), new TreeNode(1, new TreeNode(1), null)), new TreeNode(6, new TreeNode(1, new TreeNode(1), null), new TreeNode(3, null, new TreeNode(5))));
        printTree(root4);
        System.out.println();
        TreeNode result4 = solution.addOneRow(root4, 1, 3);
        
        printTree(result4);
        System.out.println("\n");
        // Output: [4,2,6,1,1,1,1,1,1,null,1,1,null,null,1,1,null,null,1,1,null,null,1,1,3,null,null,1,5]
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
