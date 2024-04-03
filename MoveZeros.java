/*
 Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 */

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int index=0;
        for(int n:nums){
            if(n!=0){
                nums[index]=n;
                index++;
            }
        }
        while(index<nums.length){
            nums[index]=0;
            index++;
        }
    }
    public static void main(String[] args) {
        MoveZeros mz=new MoveZeros();
        int[] arr=new int[]{0,1,0,3,12};
        mz.moveZeroes(arr);
        System.out.println("Array after moving zeros");
        for(int i:arr){
            System.out.print(i+" ");
        }
        arr=new int[]{0};
        mz.moveZeroes(arr);
        System.out.println("Array after moving zeros");
        for(int i:arr){
            System.out.print(i+" ");
        }

    }
    
}
