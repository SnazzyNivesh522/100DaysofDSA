/*
Bottom View of Binary Tree
Difficulty: MediumAccuracy: 54.18%Submissions: 231K+Points: 4
Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.

Note: The Input/Output format and Example given are used for the system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from the stdin/console. The task is to complete the function specified, and not to write the full code.
 

Example 1:

Input:
       1
     /   \
    3     2
Output: 3 1 2
Explanation:
First case represents a tree with 3 nodes
and 2 edges where root is 1, left child of
1 is 3 and right child of 1 is 2.

Thus nodes of the binary tree will be
printed as such 3 1 2.
Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 40 20 60 30
Your Task:
This is a functional problem, you don't need to care about input, just complete the function bottomView() which takes the root node of the tree as input and returns an array containing the bottom view of the given tree.

Expected Time Complexity: O(N*logN).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105
 */
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BottomViewBinaryTree {
    public void bottomView(Node root,int level,int vertical,Map<Integer,Pair<Node,Integer>> map){
        if(root==null) return;
        if(!map.containsKey(vertical) || level >= map.get(vertical).second){
            map.put(vertical,Pair.of(root,level));
        }
        bottomView(root.left, level + 1, vertical - 1, map);
        bottomView(root.right, level + 1, vertical + 1, map);
    }
    public ArrayList<Integer> bottomView(Node root) {
        Map<Integer,Pair<Node,Integer>> map=new TreeMap<>();
        bottomView(root, 0, 0, map);
        ArrayList<Integer> tv=new ArrayList<>();
        for(Pair<Node,Integer> pair:map.values()){
            tv.add(pair.first.data);
        }
        return tv;
        
    }
    public static void main(String[] args) {
        BottomViewBinaryTree obj=new BottomViewBinaryTree();

        Node root=new Node(1);
        root.left=new Node(3);
        root.right=new Node(2);
        System.out.println(obj.bottomView(root));

        root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(60);
        System.out.println(obj.bottomView(root));

        /*
                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14
         */
        root=new Node(20);
        root.left=new Node(8);
        root.right=new Node(22);
        root.left.left=new Node(5);
        root.left.right=new Node(3);
        // root.right.left=new Node(4);
        root.right.right=new Node(25);
        root.left.right.left=new Node(10);
        root.left.right.right=new Node(14);
        System.out.println(obj.bottomView(root));
    }
    
}
class Pair <U,V> {
    public U first;
    public V second;
    private Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
    public static <U,V> Pair<U,V> of(U a, V b) {
        return new Pair<>(a, b);
    }
}
