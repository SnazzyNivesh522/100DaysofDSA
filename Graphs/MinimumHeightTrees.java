/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 

Example 1:


Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:


Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
 

Constraints:

1 <= n <= 2 * 104
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result=new ArrayList<>();
        if(n==1){
            result.add(0);
            return result;
        } 
        HashMap<Integer,List<Integer>> adjList=new HashMap<>();
        int degree[]=new int[n];
        for(int e[]:edges){
            int u=e[0],v=e[1];
            if(!adjList.containsKey(u)){
                adjList.put(u,new ArrayList<>());
            }
            adjList.get(u).add(v);
            degree[u]++;
            if(!adjList.containsKey(v)){
                adjList.put(v,new ArrayList<>());
            }
            adjList.get(v).add(u);
            degree[v]++;
        }
        //for doing BFS
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                queue.add(i);
            }
        }
        while(n>2){
            int size=queue.size();
            n-=size;
            while(size-->0){
                int v=queue.poll();
                for(int i:adjList.get(v)){
                    degree[i]--;
                    if(degree[i]==1) queue.add(i);
                }
            }
        }
        result.addAll(queue);
        return result;
    }
    public static void main(String[] args) {
        //test cases 
        MinimumHeightTrees obj=new MinimumHeightTrees();
        int n=4;
        int[][] edges=new int[][]{{1,0},{1,2},{1,3}};
        List<Integer> result=obj.findMinHeightTrees(n,edges);
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
        n=6;
        edges=new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}};
        result=obj.findMinHeightTrees(n,edges);
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
        n=1;
        edges=new int[][]{};
        result=obj.findMinHeightTrees(n,edges);
        System.out.println(result.toString());
        
    }
}
