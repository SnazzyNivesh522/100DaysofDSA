/*
You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.

 

Example 1:


Input: root = [0,1,2,3,4,3,4]
Output: "dba"
Example 2:


Input: root = [25,1,3,1,3,0,2]
Output: "adz"
Example 3:


Input: root = [2,2,1,null,1,0,null,0]
Output: "abc"
 

Constraints:

The number of nodes in the tree is in the range [1, 8500].
0 <= Node.val <= 25
 */
/*
Algorithm
Initialize an empty string smallestString to store the lexicographically smallest string.

Call the helper function dfs(root, "").

The dfs function takes the current node root and the current string currentString as parameters.
Inside the dfs function:

If the current node root is NULL, return (base case).
Construct the currentString by appending the character corresponding to the current node's value to the beginning of the currentString.
If the current node root is a leaf node:
If smallestString is empty or if the currentString is lexicographically smaller than smallestString:
- Update smallestString to be the currentString.
Recursively call dfs on the left child of the current node (if it exists).
Recursively call dfs on the right child of the current node (if it exists).
After the dfs function call, return the smallestString.
 */
public class SmallestStringStartingFromLeaf {
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
    StringBuilder smallestString=new StringBuilder();
    private void dfs(TreeNode root,StringBuilder currString){
        if(root==null) return;

        currString.insert(0, (char) (root.val + 'a'));

        if(root.left==null && root.right==null){
            if(smallestString.isEmpty() || smallestString.compareTo(currString)>0){
                smallestString.replace(0, smallestString.length(), currString.toString());
            }
        }
        if(root.left!=null){
            dfs(root.left,currString);
        }
        if(root.right!=null){
            dfs(root.right,currString);
        }
        
        currString.deleteCharAt(0);
    }
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder(""));
        return smallestString.toString();
    }
    public static void main(String[] args) {
        SmallestStringStartingFromLeaf obj = new SmallestStringStartingFromLeaf();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1,new TreeNode(3),new TreeNode(4));
        root.right = new TreeNode(2,new TreeNode(3),new TreeNode(4));
        System.out.println(obj.smallestFromLeaf(root));

        TreeNode root2=new TreeNode(25);
        root2.left=new TreeNode(1,new TreeNode(1),new TreeNode(3));
        root2.right=new TreeNode(3,new TreeNode(0),new TreeNode(2));
        System.out.println(obj.smallestFromLeaf(root2));

        TreeNode root3=new TreeNode(2);
        root3.left=new TreeNode(2,null,new TreeNode(1,new TreeNode(0),null));
        root3.right=new TreeNode(1,new TreeNode(0),null);
        System.out.println(obj.smallestFromLeaf(root3));

        //[25,1,null,0,0,1,null,null,null,0]
        TreeNode root4=new TreeNode(25);
        root4.left=new TreeNode(1,new TreeNode(0,new TreeNode(1,new TreeNode(0),null),null),new TreeNode(0));
        System.out.println(obj.smallestFromLeaf(root4));
        
    }
}
