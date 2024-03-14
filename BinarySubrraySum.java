import java.util.HashMap;

public class BinarySubrraySum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        int currSum=0;
        HashMap<Integer,Integer> cntMap=new HashMap<>();
        for(int i:nums){
            currSum+=i;
            if(currSum==goal){
                count++;
            }
            if(cntMap.containsKey(currSum-goal)){
                count+=cntMap.get(currSum-goal);
            }
            cntMap.put(currSum,cntMap.getOrDefault(currSum,0)+1);
        }
        return count;
        
    }
    public static void main(String[] args) {
        BinarySubrraySum bs = new BinarySubrraySum();
        System.out.println("Number of subarrays with sum equal to 2 in [1,0,1,0,1] is :"+bs.numSubarraysWithSum(new int[]{1,0,1,0,1},2));
    }
    
}
