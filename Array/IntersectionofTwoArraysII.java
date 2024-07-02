/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionofTwoArraysII {
    /*
    create a hashmap based on number frequency of nums1. 
    Then for every element of  nums2, look upon the hashmap.
    If we found an intersection, deduct by 1 to avoid duplicate.       
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){ 
            return intersect(nums2,nums1);
        }
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int num:nums1){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> intersection=new ArrayList<>();
        for(int num:nums2){
            if(freqMap.containsKey(num) && freqMap.get(num)>0){
                intersection.add(num);
                freqMap.put(num,freqMap.get(num)-1);
            }
        }
        int result[]=new int[intersection.size()];
        for(int i=0;i<intersection.size();i++){
            result[i]=intersection.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        IntersectionofTwoArraysII obj=new IntersectionofTwoArraysII();
        System.out.println(Arrays.toString(obj.intersect(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(obj.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
        //test for same length array
        System.out.println(Arrays.toString(obj.intersect(new int[]{1,2,2,1}, new int[]{1,2,2,1})));
        //test for empty array
        System.out.println(Arrays.toString(obj.intersect(new int[]{}, new int[]{1,2,2,1})));
        //test for array with negative numbers
        System.out.println(Arrays.toString(obj.intersect(new int[]{-2,1,-4,-4,-2}, new int[]{-2,1,2,3,4})));
    }
}
