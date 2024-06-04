class Largest_Local_Values_in_a_Matrix {
    private int largest3x3(int grid[][], int i, int j) {
        int largest = Integer.MIN_VALUE;
        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                largest = Math.max(largest, grid[r][c]);
            }
        }
        return largest;

    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int maxLocal[][] = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                maxLocal[i][j] = largest3x3(grid, i, j);
            }
        }
        return maxLocal;
    }
}