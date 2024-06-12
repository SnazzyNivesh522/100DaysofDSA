/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 

Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
 */
public class KthSmallestElementSortedMatrix {
    int n;
    public int kthSmallest(int[][] matrix, int k) {
       if(k==1) return matrix[0][0];
       this.n=matrix.length;
       if(k==n*n) return matrix[n-1][n-1];
       int low=matrix[0][0];
       int high=matrix[n-1][n-1];
       int ans=-1;
       while(low<=high){
        int mid=(low+high)/2;
        if(countLessOREqual(mid,matrix)>=k){
            ans=mid;
            high=mid-1;
        }
        else{
            low=mid+1;
        }
       }
       return ans;
    }
    private int countLessOREqual(int mid,int [][]matrix){
        int count=0;
        int c=this.n-1;
        for(int r=0;r<this.n;r++){
            while(c>=0 && matrix[r][c]>mid){
                c--;
            }
            count+=(c+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int matrix[][]=new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(new KthSmallestElementSortedMatrix().kthSmallest(matrix, 8));
        
        matrix=new int[][]{{-5}};
        System.out.println(new KthSmallestElementSortedMatrix().kthSmallest(matrix, 1));

        matrix=new int[][]{{16, 28, 60, 64},{22, 41, 63, 91},{27, 50, 87, 93},{36, 78, 87, 94 }};
        System.out.println(new KthSmallestElementSortedMatrix().kthSmallest(matrix, 3));

        matrix=new int[][]{{10, 20, 30, 40},{15, 25, 35, 45},{24, 29, 37, 48},{2, 33, 39, 50 }};
        System.out.println(new KthSmallestElementSortedMatrix().kthSmallest(matrix, 7));
    }
}
