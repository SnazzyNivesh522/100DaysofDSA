/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0
 */
public class SubArrayProductlessK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //sliding window
        if(k<=1) return 0;
        int left=0;
        int prod=1;//product
        int count=0;
        for(int right=0;right<nums.length;right++){
            prod*=nums[right];
            while(k<=prod && left<nums.length){ //if product is more or equal(strict condition) slide right
                prod/=nums[left];
                left++;
                
            }
            //if k>prod
            //then add to result
            if(k>prod) count+=(right-left+1);

        }
        return count>0?count:0;        
    }
    public static void main(String[] args) {
        SubArrayProductlessK s = new SubArrayProductlessK();
        System.out.println("Number of subarrays in 10,5,2,6 with product less than 100 : "+s.numSubarrayProductLessThanK(new int[]{10,5,2,6},100));
        System.out.println("Number of subarrays in 1,2,3,4,5 with product less than 1 : "+s.numSubarrayProductLessThanK(new int[]{1,2,3,4,5},1));
        System.out.println("Number of subarrays in 1,1,1 with product less than 1 : "+s.numSubarrayProductLessThanK(new int[]{1,1,1},1));
        System.out.println("Number of subarrays in 100,100,100 with product less than 101 : "+s.numSubarrayProductLessThanK(new int[]{100,100,100},101));
        System.out.println("Number of subarrays in 100,100,100 with product less than 100 : "+s.numSubarrayProductLessThanK(new int[]{100,100,100},100));
    }

    
}
