/*
Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.

Return the positive integer k. If there is no such integer, return -1.

 

Example 1:

Input: nums = [-1,2,-3,3]
Output: 3
Explanation: 3 is the only valid k we can find in the array.
Example 2:

Input: nums = [-1,10,6,7,-7,1]
Output: 7
Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
Example 3:

Input: nums = [-10,8,6,7,-2,-3]
Output: -1
Explanation: There is no a single valid k, we return -1.
 

Constraints:

1 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
nums[i] != 0
 */
import java.util.HashSet;

public class LargestPositivethatExistsWithitsNegative {
    public int findMaxK(int[] nums) {
        HashSet<Integer> neg=new HashSet<>();
        for(int n:nums){
            if(n<0) neg.add(n);
        }
        int k=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && neg.contains(nums[i]-2*nums[i]) && nums[i]>k){
                k=nums[i];
            }
        }
        return k;
    }
    public static void main(String[] args) {
        System.out.println(new LargestPositivethatExistsWithitsNegative().findMaxK(new int[]{-1,2,-3,3}));
        System.out.println(new LargestPositivethatExistsWithitsNegative().findMaxK(new int[]{-1,10,6,7,-7,1}));
        System.out.println(new LargestPositivethatExistsWithitsNegative().findMaxK(new int[]{-10,8,6,7,-2,-3}));
        System.out.println(new LargestPositivethatExistsWithitsNegative().findMaxK(new int[]{49,14,13,-43,10,-34,-48,21,-43,39,4,4,-28,-7,36,-17,-32,44,-21,-7,-38,-24,30,-50,11,-33,20,36,-48,-5,-46,-37,-47,20,15,-37,-9,29,-13,-34,-44,-38,6,-7,49,4,-48,28,-22,-20,-17,42}));
        System.out.println(new LargestPositivethatExistsWithitsNegative().findMaxK(new int[]{33,14,38,-13,48,-13,-3,44,29,-1,42,20,-33,10,-49}));
    }
}