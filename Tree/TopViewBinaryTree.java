/*
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node. Also if 2 nodes are outside the shadow of the tree and are at same position then consider the left ones only(i.e. leftmost). 
For ex - 1 2 3 N 4 5 N 6 N 7 N 8 N 9 N N N N N will give 8 2 1 3 as answer. Here 8 and 9 are on the same position but 9 will get shadowed.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3
Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
Your Task:
Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 105
1 ≤ Node Data ≤ 105
 
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

public class TopViewBinaryTree {
    public void topView(Node root,int level,int vertical,Map<Integer,Pair<Node,Integer>> map){
        if(root==null) return;
        if(!map.containsKey(vertical) || level < map.get(vertical).second){
            map.put(vertical,Pair.of(root,level));
        }
        topView(root.left, level + 1, vertical - 1, map);
        topView(root.right, level + 1, vertical + 1, map);
    }
    public ArrayList<Integer> topView(Node root) {
        Map<Integer,Pair<Node,Integer>> map=new TreeMap<>();
        topView(root, 0, 0, map);
        ArrayList<Integer> tv=new ArrayList<>();
        for(Pair<Node,Integer> pair:map.values()){
            tv.add(pair.first.data);
        }
        return tv;
        
    }
    public static void main(String[] args) {
        TopViewBinaryTree obj=new TopViewBinaryTree();
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        System.out.println(obj.topView(root));
        root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(60);
        root.right.left=new Node(90);
        root.right.right=new Node(100);
        System.out.println(obj.topView(root));
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
