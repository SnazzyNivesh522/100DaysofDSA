/*
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    int n;
    List<List<Integer>> powerset = new ArrayList<>();
    void recursion(int index,List<Integer> subset,int []nums){
        if(index==n){
            powerset.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        recursion(index+1,subset,nums);

        subset.remove(subset.size()-1);

        recursion(index+1,subset,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        n=nums.length;
        recursion(0,new ArrayList<>(),nums);
        return powerset;
        // non-recusrive
        // List<List<Integer>> powerset = new ArrayList<>();
        // powerset.add(new ArrayList<>()); // Empty set

        // for (int i = 0; i < nums.length; i++) { 
        //     int size = powerset.size(); 
        //     for (int j = 0; j < size; j++) { 
        //         List<Integer> currentSubset = new ArrayList<>(powerset.get(j));
        //         currentSubset.add(nums[i]); 
        //         powerset.add(currentSubset); 
        //     }
        // }

        // return powerset;     
    }
    public static void main(String[] args) {
        int[] arr={1,2,3};
        PowerSet obj=new PowerSet();
        List<List<Integer>> powerset=obj.subsets(arr);
        for(int i=0;i<powerset.size();i++){
            System.out.println("Power Set "+(i+1)+": ");
            for(int j:powerset.get(i)){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    
}
