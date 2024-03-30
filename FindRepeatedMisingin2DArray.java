/*
 You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

 

Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
Example 2:

Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].
 */
public class FindRepeatedMisingin2DArray {
    class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int first = 0;
            int sec = 0;
    
            int n = grid.length;
    
            // XOR from 1 to n^2
            for (int i = 1; i <= n * n; i++) {
                first = first ^ i;
            }
    
            // XOR all elements from array
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sec = sec ^ grid[i][j];
                }
            }
    
            int xorBoth = first ^ sec;
    
            int diffBitPos = 0;
            // Find differentiating bit position from back
            for (int i = 0; i < 32; i++) {
                if ((xorBoth & (1 << i)) != 0) {
                    diffBitPos = i;
                    break;
                }
            }
    
            int ans0 = 0;
            int ans1 = 0;
    
            // Differentiate the both according to the diff_bit_pos
            for (int i = 1; i <= n * n; i++) {
                if ((i & (1 << diffBitPos)) != 0) {
                    ans0 ^= i;
                } else {
                    ans1 ^= i;
                }
            }
    
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((grid[i][j] & (1 << diffBitPos)) != 0) {
                        ans0 ^= grid[i][j];
                    } else {
                        ans1 ^= grid[i][j];
                    }
                }
            }
    
            // Finding the order of answer
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == ans0) {
                        // If ans0 is found then it's the repeating number
                        return new int[]{ans0, ans1};
                    }
                }
            }
    
            // If ans0 is not found in the grid, it's the missing number
            return new int[]{ans1, ans0};
        }
    }
    
}
