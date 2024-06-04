class Path_with_Maximum_Gold {
       private int grid[][];
       private int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

       public int getMaximumGold(int[][] grid) {
              this.grid = grid;
              int rows = grid.length;
              int cols = grid[0].length;
              int avail_Gold = 0;
              for (int[] row : grid) {
                     for (int gold : row) {
                            avail_Gold += gold;
                     }
              }
              int max_Gold = 0;
              boolean visited[][] = new boolean[rows][cols];
              for (int r = 0; r < rows; r++) {
                     for (int c = 0; c < cols; c++) {
                            if (grid[r][c] != 0) {
                                   max_Gold = Math.max(max_Gold, dfs(r, c, visited));
                                   if (max_Gold == avail_Gold)
                                          return max_Gold;
                            }
                     }
              }
              return max_Gold;
       }

       private int dfs(int r, int c, boolean[][] visited) {
              if (r < 0 || r == grid.length || c < 0 || c == grid[0].length || grid[r][c] == 0 || visited[r][c]) {
                     return 0;
              }
              visited[r][c] = true;
              int gold = grid[r][c];
              for (int d[] : dir) {
                     gold = Math.max(gold, grid[r][c] + dfs(r + d[0], c + d[1], visited));
              }
              visited[r][c] = false;
              return gold;

       }
}