/*
You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
Output: 2
Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
Example 2:

Input: nums = [1,1,1,1], minK = 1, maxK = 1
Output: 10
Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 */
public class CountSubarraysFixedBound {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result=0;
        int maxKindex=-1;
        int minKindex=-1;
        int left=-1;
        for(int right=0;right<nums.length;right++){
            if(nums[right]<minK || nums[right]>maxK){//out of range
                left=right;
            }
            if(nums[right]==minK){
                minKindex=right;
            }
            if(nums[right]==maxK){
                maxKindex=right;
            }
            result+=Math.max(0,Math.min(maxKindex,minKindex)-left);
        }
        return result;
        
    }
    public static void main(String[] args) {
        CountSubarraysFixedBound csfb=new CountSubarraysFixedBound();
        System.out.println(csfb.countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
        System.out.println(csfb.countSubarrays(new int[]{1,1,1,1}, 1, 1));
        System.out.println(csfb.countSubarrays(new int[]{5,6,7,8,1,2},1,7));
    }
    
}
