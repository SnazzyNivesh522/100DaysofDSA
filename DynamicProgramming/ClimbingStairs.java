/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
 */
public class ClimbingStairs {
    //TOP-DOWN DP O(N)
    private int solveDP(int n, int memo[]) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (memo[n] > 0)
            return memo[n];
        memo[n] = solveDP(n - 1, memo) + solveDP(n - 2, memo);
        return memo[n];
    }

    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return solveDP(n, memo);
    }
    // Simple Recursive solution O(2^N) -TLE
    // public int climbStairs(int n) {
    //     if (n == 0)
    //         return 1;
    //     if (n < 0)
    //         return 0;
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }
    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(2));
        System.out.println(cs.climbStairs(3));
        System.out.println(cs.climbStairs(4));
        System.out.println(cs.climbStairs(45));
    }
}
