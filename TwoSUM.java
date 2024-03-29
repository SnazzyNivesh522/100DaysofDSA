/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 */
import java.util.HashMap;
import java.util.Map;

public class TwoSUM {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)) {
                return new int[]{i,map.get(temp)};
            }
            else{
                map.put(nums[i],i);
            }
            
        }
        return null;
        
    }
    public static void main(String[] args) {
        TwoSUM sum=new TwoSUM();
        int arr[];
        arr=sum.twoSum(new int[]{3,3},6);
        System.out.println("The index in the twoSum array are "+arr[0]+" and "+arr[1]);
        arr=sum.twoSum(new int[]{2,7,11,15},9);
        System.out.println("The index in the twoSum array are "+arr[0]+" and "+arr[1]);
        arr=sum.twoSum(new int[]{3,2,4},6);
        System.out.println("The index in the twoSum array are "+arr[0]+" and "+arr[1]);
        // System.out.println(sum.twoSum(new int[]{2,7,11,15},9));
        // System.out.println(sum.twoSum(new int[]{3,2,4},6));
        // System.out.println(sum.twoSum(new int[]{3,3},6));
    }
    
}
