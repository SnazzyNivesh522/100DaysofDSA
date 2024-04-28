

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.

Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

 

Example 1:


Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
Output: [8,12,6,10,10,10]
Explanation: The tree is shown above.
We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
equals 1 + 1 + 2 + 2 + 2 = 8.
Hence, answer[0] = 8, and so on.
Example 2:


Input: n = 1, edges = []
Output: [0]
Example 3:


Input: n = 2, edges = [[1,0]]
Output: [1,1]
 

Constraints:

1 <= n <= 3 * 104
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
The given input represents a valid tree.
 */
public class SumOfDistancesInaTree {
    private int[] answer,childCnt;
    private List<Set<Integer>> graph; //for adjacency list representation
    private int n;//no of nodes
    private void postorder(int node,int parent){
        for(int child:graph.get(node)){
            if(child!=parent){
                postorder(child,node);
                childCnt[node]+=childCnt[child];
                answer[node]=answer[node]+answer[child]+childCnt[child];                
            }
        }
    }
    private void preorder(int node,int parent){
        for(int child:graph.get(node)){
            if(child!=parent){
                answer[child]=answer[node]-childCnt[child]; //if start from  parent it can reach there
                answer[child]+=(n-childCnt[child]); //staring from itself to parent takes 1 + to others left
                preorder(child,node);
            }
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n=n;
        answer=new int[n];
        childCnt=new int[n];
        graph=new ArrayList<>();
        Arrays.fill(childCnt,1);//because for leaf nodes parent is also a child
        for(int i=0;i<n;i++){
            graph.add(new HashSet<>());
        }
        for(int e[]:edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        postorder(0,-1); //gives answer[0] i.e, for root correct for else we need to compute
        preorder(0,-1);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SumOfDistancesInaTree().sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}})));
    }
    
}