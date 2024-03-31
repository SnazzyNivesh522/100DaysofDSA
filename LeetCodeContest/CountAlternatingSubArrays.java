/*
You are given a binary array nums.

We call a subarray alternating if no two adjacent elements in the subarray have the same value.

Return the number of alternating subarrays in nums.

 

Example 1:

Input: nums = [0,1,1,1]

Output: 5

Explanation:

The following subarrays are alternating: [0], [1], [1], [1], and [0,1].

Example 2:

Input: nums = [1,0,1,0]

Output: 10

Explanation:

Every subarray of the array is alternating. There are 10 possible subarrays that we can choose.

 
 */
public class CountAlternatingSubArrays {
    public long countAlternatingSubarrays(int[] nums) {
        long count=0;
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(right>0 && nums[right]==nums[right-1]){
                left=right;
            }
            count+=right-left+1;
        }
        return count;        
    }
    public static void main(String[] args) {
        // test case from leetcode
        System.out.println((new CountAlternatingSubArrays()).countAlternatingSubarrays(new int[]{0,1,1,1}));
        System.out.println((new CountAlternatingSubArrays()).countAlternatingSubarrays(new int[]{1,0,1,0}));
    }
        
}
