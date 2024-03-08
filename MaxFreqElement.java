import java.util.HashMap;

public class MaxFreqElement {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> mapElement=new HashMap<>();
        int max=1;//because of each element would be alteast 1
        for(int i=0;i<nums.length;i++){
            if(mapElement.get(nums[i])!=null){
                mapElement.put(nums[i],mapElement.get(nums[i])+1);
            }
            else{
                mapElement.put(nums[i],1);
            }
            max=Math.max(max,mapElement.get(nums[i]));

        }
        //max is 1 means all have frequency 1
        if(max==1){
            return nums.length;
        }

        // counting elements with max frequency
        int count=0;
        for(int i:mapElement.values()){
            if(max==i) count+=max;
        }
        return count;
    }
    public static void main(String[] args) {
        MaxFreqElement mfe = new MaxFreqElement();
        int nums1[]=new int[]{1,2,2,3,1,4};
        System.out.println("Number of maximum frequency elements are : "+mfe.maxFrequencyElements(nums1));
        int nums2[]=new int[]{1,2,3,4,5};
        System.out.println("Number of maximum frequency elements are : "+mfe.maxFrequencyElements(nums2));
    }
    
}
