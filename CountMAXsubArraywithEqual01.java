import java.util.HashMap;

/**
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class CountMAXsubArraywithEqual01 {

    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> sumMap=new HashMap<>();
        //replacing 0 with -1 as if equal numbers of 1 and -1 will result in sum 0
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
        }
        int currsum=0;
        int maxLength=0;
        sumMap.put(0,-1);
        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
            if(sumMap.containsKey(currsum)){
                int index=sumMap.get(currsum);
                maxLength=Math.max(maxLength,i-index);
            }
            else{
                sumMap.put(currsum,i);
            }
            
        }
        return maxLength;                
    }
    public static void main(String[] args) {
        CountMAXsubArraywithEqual01 cmae = new CountMAXsubArraywithEqual01();
        System.out.println("here {0,1,0} Count of longest contiguous subarray is:"+cmae.findMaxLength(new int[]{0,1,0}));

        System.out.println("here {1, 0, 0, 1, 0, 1, 1}Count of longest contiguous subarray is:"+cmae.findMaxLength(new int[]{1, 0, 0, 1, 0, 1, 1}));
    }
}