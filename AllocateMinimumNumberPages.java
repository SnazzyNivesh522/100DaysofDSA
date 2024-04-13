/*
 You have N books, each with A[i] number of pages. M students need to be allocated contiguous books, with each student getting at least one book.
Out of all the permutations, the goal is to find the permutation where the sum of maximum number of pages in a book allotted to a student should be minimum, out of all possible permutations.

Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

 

Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:113
Explanation:Allocation can be done in 
following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90} Maximum Pages =113.
Therefore, the minimum of these cases is 113,
which is selected as the output.

Example 2:

Input:
N = 3
A[] = {15,17,20}
M = 2
Output:32
Explanation: Allocation is done as
{15,17} and {20}
Your Task:
You don't need to read input or print anything. Your task is to complete the function findPages() which takes 2 Integers N, and m and an array A[] of length N as input and returns the expected answer.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 105
1 <= A [ i ] <= 106
1 <= M <= 105
 */
public class AllocateMinimumNumberPages {
    private static boolean isPossible(int ans,int A[],int M){
        int students=1,sum=0;
        for(int i=0;i<A.length;i++){
            if(ans<A[i]){
                return false;
            }
            if(sum+A[i]>ans){
                sum=A[i];
                students++;
            }
            else{
                sum+=A[i];
            }
        }
        if(students>M) return false;
        
        return true;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(M>N){
            return -1;
        }
        int low=A[0];
        int high=0;
        for(int i=0;i<N;i++){
            low=Math.max(low,A[i]);
            high+=A[i];
        }
        int ans=0;
        while(low<=high){
            int mid=(high+low)/2;
            if(isPossible(mid,A,M)){
                ans=mid;
                high=mid-1;
                
            }
            else{
                low=mid+1;
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        System.out.println(findPages(new int[]{12,34,67,90}, 4, 2));
        System.out.println(findPages(new int[]{15,17,20}, 3, 2));
        System.out.println("Test case passed");
    }
}
