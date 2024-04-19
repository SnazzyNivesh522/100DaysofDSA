/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    private int rows,cols;
    private void search(char[][] grid,int[][] visited,int r,int c){
        if(r<0 || c<0 || r>rows-1 || c>cols-1 || visited[r][c]==1 || grid[r][c]=='0'){
            return;
        }
        visited[r][c]=1;
        search(grid,visited,r-1,c);
        search(grid,visited,r+1,c);
        search(grid,visited,r,c+1);
        search(grid,visited,r,c-1);
    }
    public int numIslands(char[][] grid) {
        rows=grid.length;
        cols=grid[0].length;
        int[][] visited=new int[rows][cols];
        int islands=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && visited[i][j]!=1){
                    islands++;
                    search(grid,visited,i,j);
                }
            }
        }
        return islands;
    }
    public static void main(String[] args) {
        char[][] arr={{'1','1','1','1','0'},
                      {'1','1','0','1','0'},
                      {'1','1','0','0','0'},
                      {'0','0','0','0','0'}
                     };
        System.out.println("Number of Islands : "+ new NumberOfIslands().numIslands(arr));
        arr=new char[][]{{'1','1','0','0','0'},
                         {'1','1','0','0','0'},
                         {'0','0','1','0','0'},
                         {'0','0','0','1','1'}
                        };
        System.out.println("Number of Islands : "+ new NumberOfIslands().numIslands(arr));
        arr=new char[][]{{'1'},{'1'}};
        System.out.println("Number of Islands : "+ new NumberOfIslands().numIslands(arr));
    }
}
