
/*
 Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class CommonElementArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> ElementMap=new HashMap<>();
        ArrayList<Integer> common = new ArrayList<>();
        for(int i: nums1){
            ElementMap.put(i,1);
        }
        for(int i:nums2){
            int exist=ElementMap.getOrDefault(i,0);
            if(exist!=0){
                common.add(i);
                ElementMap.remove(i);
            }
        }
        int[] comm = new int[common.size()];

        for(int i=0;i<comm.length;i++){
            comm[i] = common.get(i);
        }

        return comm;
        // return common.stream().mapToInt(number -> number).toArray(); //above converting to array
                                                                        //is fast then this one         
    }
    public static void main(String[] args) {
        CommonElementArrays cea = new CommonElementArrays();
        System.out.println("Common elements of {1, 1, 2, 2, 3, 4} and {2, 2, 3, 5, 6} are: "); 
        int[] nums1={1, 1, 2, 2, 3, 4};    
        int[] nums2={2, 2, 3, 5, 6};    
        int[] result=cea.intersection(nums1, nums2);
        for (int i=0; i <result.length ; i++){  
            System.out.print(result[i] + " ");                
        }

    }
}
