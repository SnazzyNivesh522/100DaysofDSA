// You are given an array nums consisting of positive integers.

// Return the total frequencies of elements in nums such that those elements all have the maximum frequency.

// The frequency of an element is the number of occurrences of that element in the array.

 

// Example 1:

// Input: nums = [1,2,2,3,1,4]
// Output: 4
// Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
// So the number of elements in the array with maximum frequency is 4.
// Example 2:

// Input: nums = [1,2,3,4,5]
// Output: 5
// Explanation: All elements of the array have a frequency of 1 which is the maximum.
// So the number of elements in the array with maximum frequency is 5.

import java.util.HashMap;

public class MaxFreqElement {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> mapElement=new HashMap<>();
        int max=1;//because of each element would be alteast 1
        for(int i=0;i<nums.length;i++){
            if(mapElement.get(nums[i])!=null){
                mapElement.put(nums[i],mapElement.get(nums[i])+1);
            }
            else{
                mapElement.put(nums[i],1);
            }
            max=Math.max(max,mapElement.get(nums[i]));

        }
        //max is 1 means all have frequency 1
        if(max==1){
            return nums.length;
        }

        // counting elements with max frequency
        int count=0;
        for(int i:mapElement.values()){
            if(max==i) count+=max;
        }
        return count;
    }
    public static void main(String[] args) {
        MaxFreqElement mfe = new MaxFreqElement();
        int nums1[]=new int[]{1,2,2,3,1,4};
        System.out.println("Number of maximum frequency elements are : "+mfe.maxFrequencyElements(nums1));
        int nums2[]=new int[]{1,2,3,4,5};
        System.out.println("Number of maximum frequency elements are : "+mfe.maxFrequencyElements(nums2));
    }
    
}
