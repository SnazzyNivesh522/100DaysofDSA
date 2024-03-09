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
