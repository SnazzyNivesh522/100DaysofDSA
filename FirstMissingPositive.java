/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<=0){
                nums[i]=n+1;
            }
        }
        for(int i=0;i<n;i++){
            int index=Math.abs(nums[i])-1;
            if(index>=0 && index<n){
                if(nums[index]<0) continue;
                nums[index]=-nums[index];

            }
        }
        for(int i=0; i<n; i++){
            if(nums[i]>=0) return i+1;
        }            
        return n+1; 
    }
    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        System.out.println(fmp.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(fmp.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(fmp.firstMissingPositive(new int[]{7,8,9,11,12}));
        
    }
}
