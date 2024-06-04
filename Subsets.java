import java.util.ArrayList;
import java.util.List;

class Subsets {
    // int n;
    // List<List<Integer>> powerset = new ArrayList<>();
    // void recursion(int index,List<Integer> subset,int []nums){
    // if(index==n){
    // powerset.add(new ArrayList<>(subset));
    // return;
    // }
    // subset.add(nums[index]);
    // recursion(index+1,subset,nums);

    // subset.remove(subset.size()-1);

    // recursion(index+1,subset,nums);
    // }
    public List<List<Integer>> subsets(int[] nums) {
        // recursion(0,new ArrayList<>(),nums);

        // binary masking bitset approach
        int n = nums.length;
        List<List<Integer>> powerset = new ArrayList<>();
        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            List<Integer> subset = new ArrayList();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            powerset.add(subset);
        }
        return powerset;
        // non-recusrive
        // List<List<Integer>> powerset = new ArrayList<>();
        // powerset.add(new ArrayList<>()); // Empty set

        // for (int i = 0; i < nums.length; i++) {
        // int size = powerset.size();
        // for (int j = 0; j < size; j++) {
        // List<Integer> currentSubset = new ArrayList<>(powerset.get(j));
        // currentSubset.add(nums[i]);
        // powerset.add(currentSubset);
        // }
        // }

        // return powerset;
    }
}