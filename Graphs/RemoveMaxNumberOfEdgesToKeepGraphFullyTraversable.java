 /*
Alice and Bob have an undirected graph of n nodes and three types of edges:

Type 1: Can be traversed by Alice only.
Type 2: Can be traversed by Bob only.
Type 3: Can be traversed by both Alice and Bob.
Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.

Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

 

Example 1:



Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
Output: 2
Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.
Example 2:



Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
Output: 0
Explanation: Notice that removing any edge will not make the graph fully traversable by Alice and Bob.
Example 3:



Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
Output: -1
Explanation: In the current graph, Alice cannot reach node 4 from the other nodes. Likewise, Bob cannot reach 1. Therefore it's impossible to make the graph fully traversable.
 

 

Constraints:

1 <= n <= 105
1 <= edges.length <= min(105, 3 * n * (n - 1) / 2)
edges[i].length == 3
1 <= typei <= 3
1 <= ui < vi <= n
All tuples (typei, ui, vi) are distinct.
  */
  /*
   Hint 1
Build the network instead of removing extra edges
Hint 2
Suppose you have the final graph (after removing extra edges). Consider the subgraph with only the edges that Alice can traverse. What structure does this subgraph have? How many edges are there?
Hint 3
Use disjoint set union data structure for both Alice and Bob.
Hint 4
Always use Type 3 edges first, and connect the still isolated ones using other edges.
   */
 class UnionFind {
    private final int[] parent;    // Parent array to represent the disjoint set forest
    private final int[] size;      // Size array to count the number of elements in each set
    public int count;        // Count of distinct sets

    // Constructor initializes each node in its own set with size 1
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    // Find the root of the set in which element x is present
    // Uses path compression for efficiency
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // path compression
        }
        return parent[x];
    }

    // Union function to merge sets containing elements 'a' and 'b'
    // Returns true if a merge happened, false if already in the same set
    public boolean union(int a, int b) {
        int rootA = find(a - 1), rootB = find(b - 1);
        if (rootA == rootB) {
            return false;  // Already in the same set
        }
        if (size[rootA] > size[rootB]) {  // Merge smaller set into larger set
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        --count;  // Decrease the number of sets
        return true;
    }
}

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable{
    // Function to find the maximum number of edges that can be removed from the input graph
    // Returns -1 if Alice and Bob cannot both traverse the entire graph
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceSet = new UnionFind(n);
        UnionFind bobSet = new UnionFind(n);
        int numEdgesToRemove = 0;  // Tracks the number of edges we can remove

        // First, process type 3 edges which are shared by Alice and Bob
        for (int[] edge : edges) {
            int type = edge[0], u = edge[1], v = edge[2];
            if (type == 3) {
                // Union operations for shared edges. If union operation fails
                // (i.e., edge is redundant), increment numEdgesToRemove.
                if (!aliceSet.union(u, v)) {
                    numEdgesToRemove++;
                } else {
                    bobSet.union(u, v);  // We can safely ignore return val since aliceSet succeeded
                }
            }
        }

        // Process Alice-only and Bob-only edges
        for (int[] edge : edges) {
            int type = edge[0], u = edge[1], v = edge[2];
            if (type == 1 && !aliceSet.union(u, v)) {  // Alice-only edge
                numEdgesToRemove++;  // If edge is already connected then increment the removal count
            }
            if (type == 2 && !bobSet.union(u, v)) {  // Bob-only edge
                numEdgesToRemove++;  // If edge is already connected then increment the removal count
            }
        }

        // If both Alice's and Bob's sets are fully connected (i.e., count is 1 for both),
        // return number of edges removed. Otherwise, return -1 since they cannot
        // both traverse the entire graph.
        return (aliceSet.count == 1 && bobSet.count == 1) ? numEdgesToRemove : -1;
    }
    public static void main(String[] args) {
        int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable solver = new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable();
        System.out.println(solver.maxNumEdgesToRemove(4, edges)); // Output: 2
        edges = new int[][]{{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
        System.out.println(solver.maxNumEdgesToRemove(4, edges)); // Output: 0
        edges = new int[][]{{3,2,3},{1,1,2},{2,3,4}};
        System.out.println(solver.maxNumEdgesToRemove(4, edges)); // Output: -1
    }
}

