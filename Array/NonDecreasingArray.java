/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You cannot get a non-decreasing array by modifying at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int n=nums.length;
        boolean changed=false;
        for(int i=0;i<n-1;i++){
            if(nums[i]<=nums[i+1]){
                continue;
            }
            if(changed){
                return false;
            }
            // we want to decrease left element
            // only if curr element is smallest
            if(i==0 || nums[i+1]>=nums[i-1]){
                nums[i]=nums[i+1];
            }
            else{
                nums[i+1]=nums[i];
            }
            changed=true;
        }
        return true;
    }
    public static void main(String[] args) {
        NonDecreasingArray nda = new NonDecreasingArray();
        System.out.println(nda.checkPossibility(new int[]{4,2,3}));
        System.out.println(nda.checkPossibility(new int[]{4,2,1}));
        System.out.println(nda.checkPossibility(new int[]{8,4,6}));
        System.out.println(nda.checkPossibility(new int[]{8,4,2}));
        System.out.println(nda.checkPossibility(new int[]{-2, 7, -1, 0, 1, 2}));
        System.out.println(nda.checkPossibility(new int[]{-10, 10, 0 ,10, 3}));
        System.out.println(nda.checkPossibility(new int[]{3,4,2,3}));

    }
}
