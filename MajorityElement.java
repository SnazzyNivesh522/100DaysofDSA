/*
 Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        //Boyer-Moore Voting Algorithm
        int count=0;
        int majority=nums[0];
        for(int n:nums){
            if(count==0) majority=n;
            if(n==majority) count++;
            else count--;
        }
        return majority;
        /* //brute force time o(2n) space o(n)
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        int n=nums.length;
        int result=0;
        for(int i=0;i<n;i++){
            freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> val:freqMap.entrySet()){
            if(val.getValue()>n/2){
                result=val.getKey();
                break;
            }
        }
        return result;
        */
    }
    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(new int[]{3,2,3}));
        System.out.println(me.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
