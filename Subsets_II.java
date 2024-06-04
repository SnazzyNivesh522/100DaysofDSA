import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> powerset = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), powerset);
        return powerset;
    }

    private void backtrack(int index, int[] nums, List<Integer> subset, List<List<Integer>> powerset) {
        powerset.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            subset.add(nums[i]);
            backtrack(i + 1, nums, subset, powerset);
            subset.remove(subset.size() - 1);
        }
    }
}