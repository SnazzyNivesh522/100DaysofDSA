/*
There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key. If either predecessor or successor is not found, then set it to NULL.

Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 

Example 1:

Input:
      8
    /   \
   1     9
    \     \
     4    10
    /
   3
key = 8 
Output: 4 9
Explanation: 
In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.
Example 2:

Input:
        10
      /   \
     2    11
   /  \ 
  1    5
      /  \
     3    6
      \
       4
key = 11
Output: 10 -1
Explanation:In given BST, the inorder predecessor of 11 is 10 whereas it does not have any inorder successor.
Your Task: You don't need to print anything. You need to update pre with the predecessor of the key or NULL if the predecessor doesn't exist and succ to the successor of the key or NULL if the successor doesn't exist. pre and succ are passed as an argument to the function findPreSuc(). Please note, The key may be located either inside or outside the tree.

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).

Constraints: 
1 <= Number of nodes <= 104
1 <= key of node <= 107
1 <= key <= 107
 */
public class InorderPredeccessorandSuccessorBST {
    public class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        pre[0] = null;
        suc[0] = null;
        Node curr=root;
        while (curr != null) {
            if(curr.data>=key){
                curr=curr.left;
            }
            else{
                pre[0]=curr;
                curr=curr.right;
            }
            
        }
        curr=root;
        while (curr != null) {
            if(curr.data<=key){
                curr=curr.right;
            }
            else{
                suc[0]=curr;
                curr=curr.left;
            }
        }
    }
    public static void main(String[] args) {
        InorderPredeccessorandSuccessorBST tree = new InorderPredeccessorandSuccessorBST();
        Node root = tree.new Node(20);
        root.left = tree.new Node(8);   
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(12);
        root.left.right.left = tree.new Node(10);
        root.left.right.right = tree.new Node(14);
        root.right = tree.new Node(22);
        root.right.right = tree.new Node(25);
        Node[] pre = new Node[1];
        Node[] suc = new Node[1];
        tree.findPreSuc(root, pre, suc, 10);
        System.out.println(pre[0].data+" "+suc[0].data);
    }
}
