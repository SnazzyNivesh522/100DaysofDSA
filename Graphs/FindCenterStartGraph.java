/*
There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.

 

Example 1:


Input: edges = [[1,2],[2,3],[4,2]]
Output: 2
Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
Example 2:

Input: edges = [[1,2],[5,1],[1,3],[1,4]]
Output: 1
 

Constraints:

3 <= n <= 105
edges.length == n - 1
edges[i].length == 2
1 <= ui, vi <= n
ui != vi
The given edges represent a valid star graph.

Hint 1
The center is the only node that has more than one edge.
Hint 2
The center is also connected to all other nodes.
Hint 3
Any two edges must have a common node, which is the center.
 */
public class FindCenterStartGraph {
    //Greedy O(1)
    public int findCenter(int[][] edges){
        int edge_firstnode = edges[0][0];
        int edge_secondnode = edges[0][1];

        if(edge_firstnode == edges[1][0] || edge_firstnode == edges[1][1]) 
            return edge_firstnode;
        else 
            return edge_secondnode;
    }

    //Counting O(n)    
    // public int findCenter(int[][] edges) {
    //     HashMap<Integer, Integer> degreeCount = new HashMap<>();
    //     for (int edge[] : edges) {
    //         degreeCount.put(edge[0], degreeCount.getOrDefault(edge[0], 0) + 1);
    //         degreeCount.put(edge[1], degreeCount.getOrDefault(edge[1], 0) + 1);
    //     }
    //     for (int node : degreeCount.keySet()) {
    //         if (degreeCount.get(node) == edges.length) {
    //             return node;
    //         }
    //     }
    //     return -1;
    // }
    public static void main(String[] args) {
        FindCenterStartGraph fcsg = new FindCenterStartGraph();
        System.out.println(fcsg.findCenter(new int[][]{{1,2},{2,3},{4,2}}));
        System.out.println(fcsg.findCenter(new int[][]{{1,2},{5,1},{1,3},{1,4}}));
    }
    
}