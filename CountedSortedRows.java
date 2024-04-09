/*Given two integers N and M and a matrix of dimensions N*M. Count all the rows in a matrix that are sorted either in strictly increasing order or in strictly decreasing order.

Example 1:

Input:
N=3,M=3
Mat=[[1,2,3],[6,5,4],[7,9,8]]
Output:
2
Explanation:
The first row is sorted in strictly 
increasing order while the second row 
is sorted in strictly decreasing order.
Example 2:

Input:
N=3,M=3
Mat=[[1,2,3],[4,5,6],[7,8,9]]
Output:
3
Explanation:
All the rows are sorted in strictly 
increasing order.

Your Task:
You don't need to read input or print anything.Your task is to complete the function sortedCount() which takes the two integers N,M and the matrix Mat as input parameters and returns the number of rows which are sorted in either strictly increasing order or strictly decreasing order.


Expected Time Complexity:O(N*M)
Expected Auxillary Space:O(1)
 

Constraints:
1<=N,M,Mat[i][j]<=1000
*/

public class CountedSortedRows {
    int sortedCount(int N, int M, int Mat[][]) {
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(j!=M-1){
                    if(Mat[i][j]>=Mat[i][j+1]){
                        break;
                    }
                }
                if(j==M-1) count++;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=M-2;j>=0;j--){
                if(Mat[i][j]<=Mat[i][j+1]){
                    break;
                }
                if(j==0) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        CountedSortedRows r = new CountedSortedRows();
        System.out.println(r.sortedCount(3,3,new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(r.sortedCount(3,3,new int[][]{{1,2,3},{6,5,4},{7,9,8}}));
    }
    
};
