/*
You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.

 

Example 1:


Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
Output: "UURL"
Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
Example 2:


Input: root = [2,1], startValue = 2, destValue = 1
Output: "L"
Explanation: The shortest path is: 2 → 1.
 

Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
1 <= startValue, destValue <= n
startValue != destValue
 */



public class StepByStepDirectionsfromBinaryTreeNodetoAnothe {
    public static class TreeNode{
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
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        return (l == null) ? r : (r == null) ? l : root;

    }
    private boolean findPath(TreeNode start,int target,StringBuilder path){
        if(start==null) return false;

        if(start.val==target) return true;

        path.append("L");
        if(findPath(start.left,target,path)){
            return true;
        }
        path.setLength(path.length()-1);

        path.append("R");
        if(findPath(start.right,target,path)){
            return true;
        }
        path.setLength(path.length()-1);

        return false;

    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca=lowestCommonAncestor(root,startValue,destValue);
        // System.out.println(lca.val);
        StringBuilder pathTos=new StringBuilder();
        StringBuilder pathTot=new StringBuilder();

        findPath(lca,startValue,pathTos);
        findPath(lca,destValue,pathTot);

        StringBuilder finalPath=new StringBuilder();
        int i=0;
        while(i<pathTos.length() && i<pathTot.length()){
            if(pathTos.charAt(i)==pathTot.charAt(i)){
                i++;
            }
            else{
                break;
            }
        }
        for(int j=0;j<pathTos.length()-i;j++){
            finalPath.append("U");
        }
        while(i<pathTot.length()){
            finalPath.append(pathTot.charAt(i++));
        }

        
        // finalPath.append("U".repeat(pathTos.length()));
        // finalPath.append(pathTot);

        return finalPath.toString();
    }
    public static void main(String[] args) {
       
        //use the above test case
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        System.out.println(new StepByStepDirectionsfromBinaryTreeNodetoAnothe().getDirections(root, 3, 6));
        
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.left.left=new TreeNode(6);
        root1.left.right=new TreeNode(2);
        root1.left.right.left=new TreeNode(7);
        root1.left.right.right=new TreeNode(4);



        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        System.out.println(new StepByStepDirectionsfromBinaryTreeNodetoAnothe().getDirections(root1, 4, 6));

        TreeNode root3=new TreeNode(2);
        root3.left=new TreeNode(1);
        System.out.println(new StepByStepDirectionsfromBinaryTreeNodetoAnothe().getDirections(root3, 2, 1));


        

        
    }
}
