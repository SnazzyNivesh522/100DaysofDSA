/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 

Example 1:


Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]
Example 2:


Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]
 

Constraints:

n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ai < bi <= edges.length
ai != bi
There are no repeated edges.
The given graph is connected.
 */
public class RedundantConnection {
    //Using UnionFind Algorithm
    int parent[],rank[];
    private int find(int n){
        int p=parent[n];
        while(p!=parent[p]){
            parent[p]=parent[parent[p]]; //path compression
            p=parent[p];
        }
        return p;

    }
    private boolean union(int n1,int n2){
        int p1=find(n1);
        int p2=find(n2);
        if(p1==p2){
            return false;
        }
        if(rank[p1]>rank[p2]){
            parent[p2]=p1;
            rank[p1]+=rank[p2];
        }
        else{
            parent[p1]=p2;
            rank[p2]+=rank[p1];
        }
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int E=edges.length;
        parent=new int[E+1];
        rank=new int[E+1];
        for(int i=0;i<E+1;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int edge[]:edges){
            if(!union(edge[0],edge[1])){
                return new int[]{edge[0],edge[1]};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        RedundantConnection obj=new RedundantConnection();
        int[][] edges={{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] result=obj.findRedundantConnection(edges);
        System.out.println("Redundant Connection: "+result[0]+" and "+result[1]);
        edges=new int[][]{{1,2},{1,3},{2,3}};
        result=obj.findRedundantConnection(edges);
        System.out.println("Redundant Connection: "+result[0]+" and "+result[1]);
    }
}
