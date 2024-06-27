/*
You are given a 2D binary array grid. Find a rectangle with horizontal and vertical sides with the smallest area, such that all the 1's in grid lie inside this rectangle.

Return the minimum possible area of the rectangle.

 

Example 1:

Input: grid = [[0,1,0],[1,0,1]]

Output: 6

Explanation:



The smallest rectangle has a height of 2 and a width of 3, so it has an area of 2 * 3 = 6.

Example 2:

Input: grid = [[1,0],[0,0]]

Output: 1

Explanation:



The smallest rectangle has both height and width 1, so its area is 1 * 1 = 1.

 

Constraints:

1 <= grid.length, grid[i].length <= 1000
grid[i][j] is either 0 or 1.
The input is generated such that there is at least one 1 in grid.
 */
public class FindMinimumAreaCoverAllOnes {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int minRow = 1000;
        int minCol = 1000;
        int maxRow = 0;
        int maxCol = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) {
                    minRow = Math.min(minRow, r);
                    minCol = Math.min(minCol, c);
                    maxRow = Math.max(maxRow, r);
                    maxCol = Math.max(maxCol, c);
                }
            }
        }
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;
        return height * width;
    }
    public static void main(String[] args) {
        FindMinimumAreaCoverAllOnes f = new FindMinimumAreaCoverAllOnes();
        System.out.println(f.minimumArea(new int[][]{{0,1,0},{1,0,1}}));
        System.out.println(f.minimumArea(new int[][]{{1,0},{0,0}}));
    }
}
