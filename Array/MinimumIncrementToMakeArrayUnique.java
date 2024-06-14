/*
You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].
Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
 */
public class MinimumIncrementToMakeArrayUnique {
    // counting sort
    public int minIncrementForUnique(int[] nums) {
        int max = 0;
        int n = nums.length;
        int minMoves = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] freqMap = new int[max + n];
        for (int num : nums) {
            freqMap[num]++;
        }
        for (int i = 0; i < max + n; i++) {
            if (freqMap[i] > 1) {
                int extra = freqMap[i] - 1;
                freqMap[i + 1] += extra;
                freqMap[i] = 1;
                minMoves += extra;
            }
        }
        return minMoves;
    }
    // public int minIncrementForUnique(int[] nums) {
    //     Arrays.sort(nums);
    //     int minMoves = 0;
    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i - 1] >= nums[i]) {
    //             int increment = (nums[i - 1] - nums[i]) + 1;
    //             minMoves += increment;
    //             nums[i] = nums[i] + increment;
    //         }
    //     }
    //     return minMoves;
    // }
    public static void main(String[] args) {
        int nums[]=new int[]{1,2,2};
        System.out.println(new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(nums));
        nums=new int[]{3,2,1,2,1,7};
        System.out.println(new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(nums));
        nums=new int[]{1,2,3};
        System.out.println(new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(nums));
        
    }

}
