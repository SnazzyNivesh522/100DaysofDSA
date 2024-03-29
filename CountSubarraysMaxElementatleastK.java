/*
You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.

 

Example 1:

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
Example 2:

Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.
 
 */
public class CountSubarraysMaxElementatleastK {
    public long countSubarrays(int[] nums, int k) {
        int left=0;
        long result=0;
        int max=nums[0];
        for(int n:nums){
            max=Math.max(max,n);
        }
        int maxCount=0;
        for(int n:nums){
            if(n==max) maxCount++;
            while(maxCount==k){
                if(nums[left]==max){
                    maxCount--;
                }
                left++;
            }
            result+=left;
        }               
        return result;
    }
    public static void main(String[] args) {
        CountSubarraysMaxElementatleastK obj=new CountSubarraysMaxElementatleastK();
        System.out.println(obj.countSubarrays(new int[]{1,3,2,3,3}, 2));
        System.out.println(obj.countSubarrays(new int[]{1,4,2,1}, 3));
        
    }
    
}
