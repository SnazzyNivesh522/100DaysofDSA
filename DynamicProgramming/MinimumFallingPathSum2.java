/*
Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.

 

Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation: 
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.
Example 2:

Input: grid = [[7]]
Output: 7
 

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
-99 <= grid[i][j] <= 99

 */


import java.util.Arrays;

public class MinimumFallingPathSum2 {
    private int fallingPath(int row,int prevcol,int rows,int [][]grid,int [][]mem){
        if(row==rows) return 0;
        if(prevcol!=-1 && mem[row][prevcol]!=-1) return mem[row][prevcol];
        int path=Integer.MAX_VALUE;
        for(int c=0;c<rows;c++){
            if(c==prevcol){
                continue;
            }
            path=Math.min(path,grid[row][c]+fallingPath(row+1,c,rows,grid,mem));
        }
        if(prevcol!=-1) mem[row][prevcol]=path;
        return path;
    }
    public int minFallingPathSum(int[][] grid){
        int rows=grid.length;
        int mem[][]=new int[rows][rows];
        for(int m[]:mem){
            Arrays.fill(m,-1);
        }
        return fallingPath(0,-1,rows,grid,mem);
    }


    //this one also gives TLE on very large input
    // //key is (row,col)
    // private HashMap<Pair<Integer,Integer>,Integer> mem=new HashMap<>();
    // //dynamic programming smart brute force by saving results
    // private int fallingPath(int row,int col,int [][]grid){
    //     int rows=grid.length;
    //     if(row==rows-1){
    //         return grid[row][col];
    //     }
    //     if(mem.containsKey(new Pair<>(row,col))){
    //         return mem.get(new Pair<>(row,col));
    //     }
    //     int nextNode=Integer.MAX_VALUE;
    //     for(int c=0;c<rows;c++){
    //         if(c!=col){
    //             nextNode=Math.min(nextNode,fallingPath(row+1,c,grid));
    //         }
    //     }
    //     mem.put(new Pair<>(row,col),nextNode+grid[row][col]);
    //     return nextNode+grid[row][col];
    // }
    // public int minFallingPathSum(int[][] grid) {
    //     int minPath=Integer.MAX_VALUE;
    //     int cols=grid[0].length;
    //     //compute by taking every column from first row
    //     for(int c=0;c<cols;c++){
    //         minPath=Math.min(minPath,fallingPath(0,c,grid));
    //     }
    //     return minPath;
    // }

    //brute force Time limit Excedded
    // private int fallingPath(int row,int col,int [][]grid){
    //     int rows=grid.length;
    //     if(row==rows-1){
    //         return grid[row][col];
    //     }
    //     int nextNode=Integer.MAX_VALUE;
    //     for(int c=0;c<rows;c++){
    //         if(c!=col){
    //             nextNode=Math.min(nextNode,fallingPath(row+1,c,grid));
    //         }
    //     }
    //     return nextNode+grid[row][col];

    // }
    // public int minFallingPathSum(int[][] grid) {
    //     int minPath=Integer.MAX_VALUE;
    //     int cols=grid[0].length;
    //     //compute by taking every column from first row
    //     for(int c=0;c<cols;c++){
    //         minPath=Math.min(minPath,fallingPath(0,c,grid));
    //     }
    //     return minPath;
    // }
    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSum2().minFallingPathSum(new int[][]{{7}}));
        System.out.println(new MinimumFallingPathSum2().minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(new MinimumFallingPathSum2().minFallingPathSum(new int[][]{
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15}
          }));
        System.out.println(new MinimumFallingPathSum2().minFallingPathSum(new int[][]{
            {-2, -18, 31, -10, -71, 82, 47, 56, -14, 42},
            {-95, 3, 65, -7, 64, 75, -51, 97, -66, -28},
            {36, 3, -62, 38, 15, 51, -58, -90, -23, -63},
            {58, -26, -42, -66, 21, 99, -94, -95, -90, 89},
            {83, -66, -42, -45, 43, 85, 51, -86, 65, -39},
            {56, 9, 9, 95, -56, -77, -2, 20, 78, 17},
            {78, -13, -55, 55, -7, 43, -98, -89, 38, 90},
            {32, 44, -47, 81, -1, -55, -5, 16, -81, 17},
            {-87, 82, 2, 86, -88, -58, -91, -79, 44, -9},
            {-96, -14, -52, -8, 12, 38, 84, 77, -51, 52}}));
            int [][]arr=new int[200][200];
            for(int a[]:arr){
                Arrays.fill(a,99);
            }
            System.out.println(new MinimumFallingPathSum2().minFallingPathSum(arr));
          
    }
}
