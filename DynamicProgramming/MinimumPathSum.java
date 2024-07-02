/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 200
 */
import java.util.Arrays;

public class MinimumPathSum {
    private final int[][]directions={{0,1},{1,0}};
    private int memo[][];
    private int dfs(int[][] grid, int row, int col) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[row][col];
        }

        if (row >= grid.length || col >= grid[0].length) {
            return Integer.MAX_VALUE; 
        }
        if(memo[row][col]!=-1){
            return memo[row][col];
        }
        int minSum = Integer.MAX_VALUE;
        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            minSum = Math.min(minSum, dfs(grid, nextRow, nextCol));
        }
        memo[row][col]=minSum + grid[row][col];
        return memo[row][col];
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        memo=new int[rows][cols];
        for(int m[]:memo){
            Arrays.fill(m,-1);
        }

        return dfs(grid, 0, 0); 
    }
    
    public static void main(String[] args) {
        MinimumPathSum mps=new MinimumPathSum();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(mps.minPathSum(grid));
        grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(mps.minPathSum(grid));
        grid = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(mps.minPathSum(grid));
        grid = new int[][]{{1,2,3},{6,5,4},{7,9,8}};
        System.out.println(mps.minPathSum(grid));
    }
}
