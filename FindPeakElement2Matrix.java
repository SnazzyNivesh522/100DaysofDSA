/*
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

 

Example 1:



Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
Example 2:



Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 105
No two adjacent cells are equal.
 */

import java.util.Arrays;

public class FindPeakElement2Matrix {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int low=0;
        int high=m-1;
        while(low<=high){
            int mid=(low+high)/2;
            int maxrow=0;
            for(int row=0;row<n;row++){
                if(mat[row][mid]>=mat[maxrow][mid]) maxrow=row;
            }
            boolean lside=true,rside=true;
            if(mid-1>=low && mat[maxrow][mid-1]>mat[maxrow][mid]) lside=false;
            if(mid+1<=high && mat[maxrow][mid+1]>mat[maxrow][mid]) rside=false;
            if(lside && rside){
                return new int[]{maxrow,mid};
            }
            else if(!rside) low=mid+1;
            else if(!lside) high=mid-1;
        }
        return null;        
    }
    public static void main(String[] args) {
        int[][] arr={{10,20,15},{21,30,14},{7,16,32}};
        System.out.println("Expected: [1, 1]\nActual: "+Arrays.toString(new FindPeakElement2Matrix().findPeakGrid(arr)));
        arr=new int[][]{{1,4},{3,2}};
        System.out.println("Expected: [0, 1] or [1, 0]\nActual: "+Arrays.toString(new FindPeakElement2Matrix().findPeakGrid(arr)));
        //[[1,2,3,4,5,6,7,8],[2,3,4,5,6,7,8,9],[3,4,5,6,7,8,9,10],[4,5,6,7,8,9,10,11]]
        arr=new int[][]{{1,2,3,4,5,6,7,8},{2,3,4,5,6,7,8,9},{3,4,5,6,7,8,9,10},{4,5,6,7,8,9,10,11}};
        System.out.println("Expected: [3, 7]\nActual: "+Arrays.toString(new FindPeakElement2Matrix().findPeakGrid(arr)));

    
    }
}
