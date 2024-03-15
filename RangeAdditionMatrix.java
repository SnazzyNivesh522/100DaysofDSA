/*
You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

Count and return the number of maximum integers in the matrix after performing all the operations.

 

Example 1:


Input: m = 3, n = 3, ops = [[2,2],[3,3]]
Output: 4
Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
Example 2:

Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
Output: 4
Example 3:

Input: m = 3, n = 3, ops = []
Output: 9
 */
public class RangeAdditionMatrix {
    public int maxCount(int m, int n, int[][] ops) {
        //Hint: there is no matrix in this problem
        //find minimum no of rows and columns affected
        int row=m;
        int col=n;
        for(int i=0;i<ops.length;i++){
            row=Math.min(row,ops[i][0]);
            col=Math.min(col,ops[i][1]);
        }
        return row*col;
        
    }
    public static void main(String[] args) {
        RangeAdditionMatrix ramm = new RangeAdditionMatrix();
        System.out.println("Maximum number of cells that can be increased : " + ramm.maxCount(3, 3, new int[][]{{2,2},{3,3}}));

        System.out.println("Maximum number of cells that can be increased : " + ramm.maxCount(3, 3, new int[][]{{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3}}));
    }
    
}
