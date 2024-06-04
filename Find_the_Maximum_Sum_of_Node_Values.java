import java.util.Arrays;

class Find_the_Maximum_Sum_of_Node_Values {
       public long maximumValueSum(int[] nums, int k, int[][] edges) {
              int n = nums.length;
              int delta[] = new int[n];
              long max_sum = 0;
              for (int i = 0; i < n; i++) {
                     delta[i] = (nums[i] ^ k) - nums[i];
                     max_sum += nums[i];
              }
              Arrays.sort(delta);
              for (int i = n - 1; i >= 0; i -= 2) {
                     if (i == 0)
                            break;
                     int sum_plus = delta[i - 1] + delta[i];
                     if (sum_plus <= 0) {
                            break;
                     }
                     max_sum += sum_plus;
              }
              return max_sum;

       }
}