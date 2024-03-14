/*
Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.

Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.

 

Example 1:

Input: nums1 = [1,2,3], nums2 = [2,4]
Output: 2
Explanation: The smallest element common to both arrays is 2, so we return 2.
Example 2:

Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
Output: 2
Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
 */
public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i,j;
        i=j=0;
        while(i<m && j<n){
            if(nums1[i]==nums2[j]){
                return nums1[i];
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                i++;
            }

        }
        // no common
        return -1;
        
    }
    public static void main(String[] args) {
        //generate test case for above here
        MinimumCommonValue minCV = new MinimumCommonValue();
        int nums1[]=new int[]{1,2,3};
        int nums2[]=new int[]{2,4};
        int nums3[]=new int[]{0,100};
        System.out.println("Min Common Value is: " + minCV.getCommon(nums1,nums2));
        System.out.println("Min Common Value is: " + minCV.getCommon(nums1,nums3));

    
    }
    
}
