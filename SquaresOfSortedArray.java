/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

 */

import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        int left=0;
        int right=n-1;
        int i=n-1;
        while(left<=right){
            if(Math.abs(nums[left])>Math.abs(nums[right])){
                result[i--]=nums[left]*nums[left];
                left++;
            }
            else{
                result[i--]=nums[right]*nums[right];
                right--;
            }
        }
        return result;
        
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(new int[]{-7,-3,2,3,11})));
    }
}
