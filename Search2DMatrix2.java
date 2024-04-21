/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109

 */
public class Search2DMatrix2 {
    // private boolean binarySearch(int arr[],int target){
    //     int low=0;
    //     int high=arr.length-1;
    //     while(low<=high){
    //         int mid=(low+high)/2;
    //         if(arr[mid]==target) return true;
    //         else if(arr[mid]<target){
    //             low=mid+1;
    //         }
    //         else{
    //             high=mid-1;
    //         }
    //     }
    //     return false;
    // }
    // public boolean searchMatrix(int[][] matrix, int target) {
    //    for(int row[]:matrix){
    //         if(binarySearch(row,target)) return true;
    //    }
    //    return false;
    // }
    public boolean searchMatrix(int[][] matrix, int target){
        int rows=matrix.length;
        int cols=matrix[0].length;
        int r=0;
        int c=cols-1;
        while(r<rows && c>=0){
            int mid=matrix[r][c];
            if(mid==target) return true;
            else if(target < mid){
                c--;
            }
            else{
                r++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Search2DMatrix2 s = new Search2DMatrix2();
        System.out.println(s.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));
        System.out.println(s.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},20));
        System.out.println(s.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},10));
        System.out.println(s.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},0));
        System.out.println(s.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},100));
        
    }
    
}