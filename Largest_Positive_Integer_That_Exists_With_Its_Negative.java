import java.util.HashSet;

class Largest_Positive_Integer_That_Exists_With_Its_Negative {
       public int findMaxK(int[] nums) {
              HashSet<Integer> neg = new HashSet<>();
              for (int n : nums) {
                     if (n < 0)
                            neg.add(n);
              }
              System.out.println(neg);
              int k = -1;
              int largest = 0;
              for (int i = 0; i < nums.length; i++) {
                     if (nums[i] > 0 && neg.contains(nums[i] - 2 * nums[i]) && nums[i] > largest) {
                            k = nums[i];
                            largest = nums[i];
                     }
              }
              return k;
       }
}