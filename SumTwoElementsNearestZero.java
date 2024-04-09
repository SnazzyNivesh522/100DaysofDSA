import java.util.Arrays;

/**
 * SumTwoElementsNearestZero
 Given an integer array of N elements. You need to find the maximum sum of two elements such that sum is closest to zero.

Example 1:

Input:
N = 3
arr[] = {-8 -66 -60}
Output: -68
Explanation: Sum of two elements closest to 
zero is -68 using numbers -60 and -8.
Example 2:

Input: 
N = 6
arr[] = {-21 -67 -37 -18 4 -65}
Output: -14
Explanation: Sum of two elements closest to
zero is -14 using numbers -18 and 4.
Note : In Case if we have two of more ways to form sum of two elements closest to zero return the maximum sum.


Your Task:
You don't need to read input or print anything. You just need to complete the function closestToZero() which takes an array arr[] and its size n as inputs and returns the maximum sum closest to zero that can be formed by summing any two elements in the array.


Expected Time Complexity: O(N*logN).
Expected Auxiliary Space: O(1).


Constraints:
2 ≤ N ≤ 5 * 105
-106 ≤ arr[i] ≤ 106
 */
public class SumTwoElementsNearestZero {
    public static int closestToZero (int arr[], int n)
    {
        Arrays.sort(arr);
        int left=0,right=n-1;
        int closestSum = Integer.MAX_VALUE;
        int sum=0;
        while(left < right){
            sum=arr[left]+arr[right];
            if(sum==0){
                return 0;
            }
            if(Math.abs(sum)<Math.abs(closestSum)){
                closestSum=sum;
            }
            else if(Math.abs(sum)==Math.abs(closestSum)){
                closestSum=Math.max(closestSum,sum);
            }
            if (sum<0){
                left++;
            }
            else{
                right--;
            }
        }
        return closestSum;
        
    }
    public static void main(String[] args) {
        int arr[]={-8 ,-66, -60};
        System.out.println(closestToZero(arr,3));
        arr= new int[]{-21, -67, -37, -18, 4, -65};
        System.out.println(closestToZero(arr,6));

        arr=new int[]{29, 13, -6, -32, -12};
        System.out.println(closestToZero(arr,5));

    }
    
}