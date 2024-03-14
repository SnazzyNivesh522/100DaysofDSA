
// Count Submatrices with Top-Left Element and Sum Less Than k
/*
You are given a 0-indexed integer matrix grid and an integer k.

Return the number of 
submatrices
 that contain the top-left element of the grid, and have a sum less than or equal to k.

https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/description/
 */
public class SubmatricesLessThanK {
    public int countSubmatrices(int[][] grid, int k) {
        int count=0;

        int cols=grid[0].length;
        int rows=grid.length;

        int sum[][]=new int[rows][cols];
        
        for(int i=0;i<rows;i++){

            for(int j=0;j<cols;j++){

                if(i==0 && j==0){
                    sum[i][j]=grid[i][j];
                }
                else if(i==0){
                    sum[i][j]=sum[i][j-1] + grid[i][j];
                } 
                else if(j==0){
                    sum[i][j]=sum[i-1][j] + grid[i][j];
                }
                else{
                    sum[i][j]=(grid[i][j] + sum[i-1][j] + sum[i][j-1]) - sum[i-1][j-1]; 
                } 


                if(sum[i][j]<=k){
                    count++;
                }
            }
        }
        return count;
        
    }
        public static void main(String[] args) {
        // write your code here
        SubmatricesLessThanK sl = new SubmatricesLessThanK();
        int grid[][]=new int[][]{{7,2,9},{1,5,0},{2,6,6}};
        System.out.println("Count of submatrices with top left element and sum less than or equal to K is: " + sl.countSubmatrices(grid, 20));
    }
    
}
