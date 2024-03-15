

/*
 Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
import java.util.Arrays;
public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length];
        Arrays.fill(result,1);
        int leftptr=1;
        int rightptr=1;
        int j=nums.length-1;
        for(int i=0;i<nums.length-1;i++){
            leftptr*=nums[i];
            result[i+1]*=leftptr;

            rightptr*=nums[j];
            result[j-1]*=rightptr;
            j--;
        }
        return result;
        
    }
    public static void main(String[] args) {
        ProductArrayExceptSelf paes = new ProductArrayExceptSelf();
        System.out.println(Arrays.toString(paes.productExceptSelf(new int[]{1,2,3,4})));
    }
}