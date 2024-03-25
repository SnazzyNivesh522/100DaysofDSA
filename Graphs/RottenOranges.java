/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
import java.util.LinkedList;
import java.util.Queue;
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int time = 0;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>(); // rotten queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) { //counting fresh oranges
                    fresh++;
                }
                if (grid[i][j] == 2) { //coordinates of rotten oranges in queue
                    q.offer(new int[] { i, j });
                }
            }
        }
        if (fresh == 0)
            return 0;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        while (!q.isEmpty() && fresh > 0) {
            int sz=q.size();
            for (int i = 0; i < sz; i++) {                
                int coordinates[] = q.poll();
                for (int dir[] : directions) {
                    int x = coordinates[0] + dir[0];
                    int y = coordinates[1] + dir[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new int[] { x, y });
                        fresh--;
                    }
                }
            }  
            time++;          
        }
        return fresh == 0 ? time : -1;
    }
    public static void main(String[] args) {
        RottenOranges ro=new RottenOranges();
        int[][] grid=new int[][]{{2,1,1},{1,1,1},{0,1,1}};
        System.out.println("{{2,1,1},{1,1,1},{0,1,1}}\n"+ro.orangesRotting(grid));

        int[][] grid1=new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        System.out.println("{{2,1,1},{0,1,1},{1,0,1}}\n"+ro.orangesRotting(grid1));

        grid=new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println("{{2,1,1},{1,1,0},{0,1,1}}\n"+ro.orangesRotting(grid));

        grid=new int[][]{{0,2}};
        System.out.println("{{0,2}}\n"+ro.orangesRotting(grid));


        
    }
    
}
