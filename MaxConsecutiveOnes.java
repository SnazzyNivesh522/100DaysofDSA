public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        //sliding window
        int left=0;
        int count=0;
        int maxcount=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==1){
                count++;
                maxcount=Math.max(maxcount,count);
            }
            else{
                
                count=0;
                left=right+1;
            }
                
        }
        return maxcount;        
    }
    public static void main(String[] args) {
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        System.out.println("Maximum consecutive 1's in array is: " + mco.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println("Maximum consecutive 1's in array is: " + mco.findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
    
}
