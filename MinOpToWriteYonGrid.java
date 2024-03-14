/*
 You are given a 0-indexed n x n grid where n is odd, and grid[r][c] is 0, 1, or 2.

We say that a cell belongs to the Letter Y if it belongs to one of the following:

The diagonal starting at the top-left cell and ending at the center cell of the grid.
The diagonal starting at the top-right cell and ending at the center cell of the grid.
The vertical line starting at the center cell and ending at the bottom border of the grid.
The Letter Y is written on the grid if and only if:

All values at cells belonging to the Y are equal.
All values at cells not belonging to the Y are equal.
The values at cells belonging to the Y are different from the values at cells not belonging to the Y.
Return the minimum number of operations needed to write the letter Y on the grid given that in one operation you can change the value at any cell to 0, 1, or 2.

https://leetcode.com/problems/minimum-operations-to-write-the-letter-y-on-a-grid/description/
 */
import java.util.ArrayList;
import java.util.Collections;

public class MinOpToWriteYonGrid {
    public int minimumOperationsToWriteY(int[][] grid) {
        //possibilities 6 subcases
        int a,b,c,d,e,f;
        //Y=0 else 1
        a=subCases(grid,0,1);
        //Y=0 else 2
        b=subCases(grid,0,2);
        //Y=1 else 0
        c=subCases(grid,1,0);
        //Y=1 else 2
        d=subCases(grid,1,2);
        //Y=2 else 0
        e=subCases(grid,2,0);
        //Y=2 else 1
        f=subCases(grid,2,1);
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, a, b, c, d, e, f);

        int minOp=Collections.min(list);
        return minOp;
        
    }
    public int subCases(int grid[][],int cellY,int cellNotY){
        int minOp=0;
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //case 1 diagonal starting at the top-left 
                if((i==j) && i<=n/2 && j<=n/2){
                    if(grid[i][j]!=cellY) minOp++; 
                }
                //case 2 diagonal starting at the top-right cell
                else if((i+j==n-1) && i<=n/2 && j>=n/2){
                    if(grid[i][j]!=cellY) minOp++;
                    
                }
                //case 3 vertical line starting at the center cell 
                else if(j==n/2 && i>=n/2){
                    if(grid[i][j]!=cellY) minOp++;                     
                }
                //remaining cells not in Y
                else{
                    if(grid[i][j]!=cellNotY) minOp++;
                }
            }
        }
        return minOp;
    }
    public static void main(String[] args) {
        MinOpToWriteYonGrid m=new MinOpToWriteYonGrid();
        int grid[][]=new int[][]{{1,2,2},{1,1,0},{0,1,0}};
        System.out.println("the minimum number of operations needed to write the letter Y on the grid:"+ m.minimumOperationsToWriteY(grid));
        int grid1[][]={{0,1,0,1,0},{2,1,0,1,2},{2,2,2,0,1},{2,2,2,2,2},{2,1,2,2,2}};
        System.out.println("Minimum operations to write 'y' on the given grid is: "+m.minimumOperationsToWriteY(grid1));

    }
    
}
