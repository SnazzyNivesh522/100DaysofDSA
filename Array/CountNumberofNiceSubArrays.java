/*
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length 


Hint 1
After replacing each even by zero and every odd by one can we use prefix sum to find answer ?
Hint 2
Can we use two pointers to count number of sub-arrays ?
Hint 3
Can we store indices of odd numbers and for each k indices count number of sub-arrays contains them ?
 */

public class CountNumberofNiceSubArrays {
    //3 pointer sliding window
    public int numberOfSubarrays(int[] nums, int k) {
        // int leftNear,leftFar,right;
        int niceSubArray=0;
        int n=nums.length;
        int left=0,mid=0;
        int oddCount=0;
        for(int right=0;right<n;right++){
            if(nums[right]%2==1){
                oddCount++;
            }
            while(oddCount>k){
                if(nums[left]%2==1){
                    oddCount--;
                }
                left++;
                mid=left;
            }
            if(oddCount==k){
                while(nums[mid]%2==0){
                    mid++;
                }
                niceSubArray+=(mid-left+1);
            }
        }
        return niceSubArray;        
    }
    public static void main(String[] args) {
        CountNumberofNiceSubArrays solution = new CountNumberofNiceSubArrays();
        System.out.println(solution.numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
        System.out.println(solution.numberOfSubarrays(new int[]{2,4,6}, 1));
        System.out.println(solution.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
        System.out.println(solution.numberOfSubarrays(new int[]{2,2,1,1,2,1,1}, 3));
    }
}