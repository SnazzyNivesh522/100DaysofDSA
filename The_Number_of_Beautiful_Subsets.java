import java.util.HashMap;

class The_Number_of_Beautiful_Subsets {
   private HashMap<Integer, Integer> freq;

   private int beautifulSubsets(int[] nums, int k, int i) {
      if (i == nums.length) {
         return 1;
      }
      int result = beautifulSubsets(nums, k, i + 1);
      if (!freq.containsKey(nums[i] - k) && !freq.containsKey(nums[i] + k)) {
         freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
         result += beautifulSubsets(nums, k, i + 1);
         freq.put(nums[i], freq.get(nums[i]) - 1);
         if (freq.get(nums[i]) == 0) {
            freq.remove(nums[i]);
         }
      }
      return result;
   }

   public int beautifulSubsets(int[] nums, int k) {
      freq = new HashMap<Integer, Integer>();
      return beautifulSubsets(nums, k, 0) - 1;
   }
}