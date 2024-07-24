/*
Given an integer array(0-based indexing) a of size n. Your task is to return the maximum value of the sum of i*a[i] for all 0<= i <=n-1, where a[i] is the element at index i in the array. The only operation allowed is to rotate(clockwise or counterclockwise) the array any number of times.

Example 1:

Input: n = 4, a[] = {8, 3, 1, 2}
Output: 29
Explanation: All the configurations possible by rotating the elements are:
3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11, so the maximum sum will be 29.
Example 2:

Input: n = 3, a[] = {1, 2, 3}
Output: 8
Explanation: All the configurations possible by rotating the elements are:
1 2 3 here sum is 1*0+2*1+3*2 = 8
3 1 2 here sum is 3*0+1*1+2*2 = 5
2 3 1 here sum is 2*0+3*1+1*2 = 5, so the maximum sum will be 8.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1<=n<=105
1<=a[]<=106
 */
public class MaxSuminTheConfiguration {

    public long max_sum(int nums[], int n) {
        long currSum=0;
        for(int val:nums){
            currSum+=val;
        }
        long maxSum=0;
        long currMulSum=0;
        for(int i=0;i<n;i++){
            currMulSum+= (long)i*nums[i];
        }
        maxSum=currMulSum;
        
        for(int i=1;i<n;i++){
            long nextMulSum=currMulSum-(currSum-nums[i-1])+ (long)nums[i-1]*(n-1);
            currMulSum=nextMulSum;
            maxSum=Math.max(maxSum,currMulSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaxSuminTheConfiguration obj=new MaxSuminTheConfiguration();
        int nums[]={8, 3, 1, 2};
      
        System.out.println(obj.max_sum(nums, nums.length));

        int nums1[]={1, 2, 3};
        System.out.println(obj.max_sum(nums1, nums1.length));
    }
}