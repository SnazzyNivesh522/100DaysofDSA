import java.util.ArrayList;
import java.util.List;

class Sum_of_All_Subset_XOR_Totals {
       public int subsetXORSum(int[] nums) {
              // non-recusrive
              List<List<Integer>> powerset = new ArrayList<>();
              powerset.add(new ArrayList<>()); // Empty set

              for (int i = 0; i < nums.length; i++) {
                     int size = powerset.size();
                     for (int j = 0; j < size; j++) {
                            List<Integer> currentSubset = new ArrayList<>(powerset.get(j));
                            currentSubset.add(nums[i]);
                            powerset.add(currentSubset);
                     }
              }

              int XORtotal = 0;
              for (List<Integer> subset : powerset) {
                     int currXOR = 0;
                     for (int val : subset) {
                            currXOR ^= val;
                     }
                     XORtotal += currXOR;
              }
              return XORtotal;
       }
}