class Score_After_Flipping_Matrix {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // we want our MSB to be 1 if not then we need to flip the entire row
        for (int r = 0; r < m; r++) {
            if (grid[r][0] == 0) {
                for (int c = 0; c < n; c++) {
                    grid[r][c] = 1 - grid[r][c]; // toggling
                }
            }
        }

        // we want to have more 1s than 0s in each column
        // dont touch 1st column as already we have set all to 1 above
        for (int c = 1; c < n; c++) {
            int zeros = 0;
            for (int r = 0; r < m; r++) {
                if (grid[r][c] == 0) {
                    zeros++;
                }
            }
            if (zeros > m - zeros) {
                for (int r = 0; r < m; r++) {
                    grid[r][c] = 1 - grid[r][c]; // toggling
                }
            }
        }
        int score = 0;
        for (int r = 0; r < m; r++) {
            int decimalNumber = 0;
            int base = 1;
            for (int c = n - 1; c >= 0; c--) {
                decimalNumber += grid[r][c] * base;
                base *= 2;
            }
            score += decimalNumber;
        }
        return score;
    }
}