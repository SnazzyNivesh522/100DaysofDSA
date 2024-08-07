/*
You are given an m x n binary matrix grid.

A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score after making any number of moves (including zero moves).

 

Example 1:


Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
Example 2:

Input: grid = [[0]]
Output: 1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
grid[i][j] is either 0 or 1.
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //we want our MSB to be 1 if not then we need to flip the entire row
        for(int r=0;r<m;r++){
            if(grid[r][0]==0){
                for(int c=0;c<n;c++){
                    grid[r][c]=1-grid[r][c]; //toggling
                }
            }
        }

        //we want to have more 1s than 0s in each column
        //dont touch 1st column as already we have set all to 1 above
        for(int c=1;c<n;c++){
            int zeros=0;
            for(int r=0;r<m;r++){
                if(grid[r][c]==0){
                    zeros++;
                }
            }
            if(zeros>m-zeros){
                for(int r=0;r<m;r++){
                    grid[r][c]=1-grid[r][c]; //toggling
                }
            }
        }
        int score=0;
        for(int r=0;r<m;r++){
            int decimalNumber=0;
            int base =1;
            for(int c=n-1;c>=0;c--){
                decimalNumber+=grid[r][c]* base;
                base*=2;
            }
            score+=decimalNumber;
        }
        return score;
    }
    public static void main(String[] args) {
        int [][] g={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        ScoreAfterFlippingMatrix s=new ScoreAfterFlippingMatrix();
        System.out.println(s.matrixScore(g));
        g=new int[][]{{0}};
        System.out.println(s.matrixScore(g));
    }
}
