import java.util.HashMap;

public class MaximumSizeSubarraySumEqualK {
    public int maxSubArrayLenSumsK(int[] nums, int k) {
        int right=0;
        int sum=0;
        int max=0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        while(right<nums.length){
            sum+=nums[right];
            if(sum==k){
                max=right+1;
            }
            if(!sumMap.containsKey(sum)){
                sumMap.put(sum, right);
            }
            if(sumMap.containsKey(sum-k)){               
                max=Math.max(max,right-sumMap.get(sum-k));
            }
            right++;
        }        
        return max;
    }
    public static void main(String[] args) {
        MaximumSizeSubarraySumEqualK mssasuk = new MaximumSizeSubarraySumEqualK();
        System.out.println(mssasuk.maxSubArrayLenSumsK(new int[]{23,-25,66,4,-78,92}, 82));//should print  6
        System.out.println(mssasuk.maxSubArrayLenSumsK(new int[]{1,-1,5,-2,3}, 3));//should print  4
        System.out.println(mssasuk.maxSubArrayLenSumsK(new int[]{-2,-1,2,1}, 1));//should print  2
        System.out.println(mssasuk.maxSubArrayLenSumsK(new int[]{10, 5, 2, 7, 1, 9 }, 15)); //should print 4
        System.out.println(mssasuk.maxSubArrayLenSumsK(new int[]{ -5, 8, -14, 2, 4, 12 }, -5)); //should print 5

    }
}
