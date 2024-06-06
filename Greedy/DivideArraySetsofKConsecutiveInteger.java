/*
Given an array of integers nums and a positive integer k, check whether it is possible to divide this array into sets of k consecutive numbers.

Return true if it is possible. Otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
Example 3:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.
 

Constraints:

1 <= k <= nums.length <= 105
1 <= nums[i] <= 109
 

Note: This question is the same as 846: https://leetcode.com/problems/hand-of-straights/
 */

import java.util.Arrays;
import java.util.HashMap;

public class DivideArraySetsofKConsecutiveInteger {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n=nums.length;
        if(n % k != 0){
            return false;
        }
        Arrays.sort(nums);
        HashMap<Integer,Integer> countMap=new HashMap<>();
        for(int num:nums){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
    
        for(int num:nums){
            if(countMap.get(num)>0){
                for(int i=0;i<k;i++){
                    if(countMap.getOrDefault(num+i,0)==0){
                        return false;
                    }
                    countMap.put(num+i,countMap.get(num+i)-1);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Test cases code
        DivideArraySetsofKConsecutiveInteger obj=new DivideArraySetsofKConsecutiveInteger();
        System.out.println(obj.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6},4));
        System.out.println(obj.isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11},3));
        System.out.println(obj.isPossibleDivide(new int[]{1,2,3,4},3));
        System.out.println(obj.isPossibleDivide(new int[]{1,2,3,4,5,6},3));
        System.out.println(obj.isPossibleDivide(new int[]{1,2,3,4,5,6,7},3));
    }
}
