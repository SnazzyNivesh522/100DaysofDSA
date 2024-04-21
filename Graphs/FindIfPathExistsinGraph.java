/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 

Example 1:


Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2
Example 2:


Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 

Constraints:

1 <= n <= 2 * 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * FindIfPathExistsinGraph
 */
public class FindIfPathExistsinGraph {
    private boolean visited[];
    private int comp[];
    private void bfs(Map<Integer, List<Integer>> graph,int source,int c){
        visited[source]=true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if(graph.get(curr)==null){
                continue;
            }
            for(int k:graph.get(curr)){
                if(!visited[k]){
                    visited[k]=true;
                    comp[k]=c;
                    queue.offer(k);
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int []edge:edges){
            int s=edge[0];
            int d=edge[1];
            if(!graph.containsKey(s)){
                graph.put(s,new ArrayList<Integer>());
            }
            graph.get(s).add(d);
            if(!graph.containsKey(d)){
                graph.put(d,new ArrayList<Integer>());
            }
            graph.get(d).add(s);
        }
        visited=new boolean[n];
        comp=new int[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                comp[i]=++c;
                bfs(graph,i,comp[i]);
            }
        }
        
        return comp[source]==comp[destination];

    }
    public static void main(String[] args) {
        FindIfPathExistsinGraph f=new FindIfPathExistsinGraph();
        System.out.println(f.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
        System.out.println(f.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
        System.err.println(f.validPath(5, new int[][]{{0,4}},0,4));
    }
    
}