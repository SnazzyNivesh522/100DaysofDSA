/*
You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing.

 

Example 1:

Input: nums = [1,4,3,3,2]

Output: 2

Explanation:

The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].

The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].

Hence, we return 2.

Example 2:

Input: nums = [3,3,3,3]

Output: 1

Explanation:

The strictly increasing subarrays of nums are [3], [3], [3], and [3].

The strictly decreasing subarrays of nums are [3], [3], [3], and [3].

Hence, we return 1.

Example 3:

Input: nums = [3,2,1]

Output: 3

Explanation:

The strictly increasing subarrays of nums are [3], [2], and [1].

The strictly decreasing subarrays of nums are [3], [2], [1], [3,2], [2,1], and [3,2,1].

Hence, we return 3.

 

Constraints:

1 <= nums.length <= 50
1 <= nums[i] <= 50

 */

import java.util.Arrays;

public class LongestStrictlyIncreasinDecreasingSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int[] increasing = new int[n];
        int[] decreasing = new int[n];
        Arrays.fill(increasing, 1);
        Arrays.fill(decreasing, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing[i] = increasing[i - 1] + 1;
            }
            if (nums[i] < nums[i - 1]) {
                decreasing[i] = decreasing[i - 1] + 1;
            }
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, Math.max(increasing[i], decreasing[i]));
        }

        return maxLen;
        
    }
    public static void main(String[] args) {
        LongestStrictlyIncreasinDecreasingSubarray lsiidsa=new LongestStrictlyIncreasinDecreasingSubarray();
        System.out.println(lsiidsa.longestMonotonicSubarray(new int[]{1,4,3,3,2})); //Expected 4
        System.out.println(lsiidsa.longestMonotonicSubarray(new int[]{3,3,3,3})); //Expected 1
        System.out.println(lsiidsa.longestMonotonicSubarray(new int[]{9,8,7,6,5,4,3,2,1})); //Expected 1
        System.out.println(lsiidsa.longestMonotonicSubarray(new int[]{3,2,1})); //Expected 3
    }
}
