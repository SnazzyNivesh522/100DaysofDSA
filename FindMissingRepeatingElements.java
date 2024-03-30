/*
 Given an unsorted array of size n. Array elements are in the range of 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.

Examples: 

Input: arr[] = {3, 1, 3}
Output: Missing = 2, Repeating = 3
Explanation: In the array, 2 is missing and 3 occurs twice 

Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1


 */

import java.util.Arrays;

public class FindMissingRepeatingElements {
    public int[] findMissingAndRepeating(int nums[]){
        int n=nums.length;
        int missing=0;
        int repeating=0;
        for(int i=0;i<n;i++){
            int temp=Math.abs(nums[i]);
            if(nums[temp-1]>0){
                nums[temp-1]=-nums[temp-1];
            }
            else{
                repeating=temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                missing=i+1;
                break;
            }
        }
        return new int[]{missing,repeating};
        
    }
    public static void main(String[] args) {
        FindMissingRepeatingElements fmre = new FindMissingRepeatingElements();
        System.out.println(Arrays.toString(fmre.findMissingAndRepeating(new int[]{3, 1, 3})));
        System.out.println(Arrays.toString(fmre.findMissingAndRepeating(new int[]{4, 3, 6, 2, 1, 1})));
    }
    
}
