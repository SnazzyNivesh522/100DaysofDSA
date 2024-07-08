/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */

import java.util.Arrays;

public class CointChange {
    /*
    Coin change by finding no of ways HackerRank Problem
    private long[][] memo;

    public long getWays(List<Long> coins,int amount) {

        memo = new long[coins.size()][amount + 1];
        for (long m[] : memo) {
          Arrays.fill(m, -1L); // Fill with -1L (long value)
        }
        for (int i = 0; i < coins.size(); i++) {
          memo[i][0] = 1;
        }

        return findWays(0, amount, coins);
    }
    private long findWays(int idx, long remainingAmount, List<Long> coins) {
        if (idx >= coins.size() || remainingAmount < 0) return 0;

    
        if (memo[idx][(int) remainingAmount] != -1L) return memo[idx][(int) remainingAmount];
        long ways = 0;
        if (coins.get(idx) <= remainingAmount) {
            ways = findWays(idx, remainingAmount - coins.get(idx), coins);
            ways += findWays(idx + 1, remainingAmount, coins);
        } 
        else {
            ways = findWays(idx + 1, remainingAmount, coins); 
        }
        memo[idx][(int) remainingAmount] = ways;

        return ways;
    }
    public static void main(String[] args) {
        long[] coins={1,2,5};
        int amount=11;
        List<Long> coinsList=Arrays.stream(coins).boxed().collect(Collectors.toList());
        System.out.println(new CointChange().getWays(coinsList,amount));

        coins=new long[]{2};
        amount=3;
        coinsList=Arrays.stream(coins).boxed().collect(Collectors.toList());
        System.out.println(new CointChange().getWays(coinsList,amount));

        coins=new long[]{1};
        amount=0;
        coinsList=Arrays.stream(coins).boxed().collect(Collectors.toList());
        System.out.println(new CointChange().getWays(coinsList,amount));

        coins=new long[]{2,5,3,6};
        amount=10;
        coinsList=Arrays.stream(coins).boxed().collect(Collectors.toList());
        System.out.println(new CointChange().getWays(coinsList,amount));
    }*/
   
    private int memo[][];
    private int findMinCoins(int []coins,int idx,int amount){
        if(idx>=coins.length || amount<=0) return amount==0 ? 0 : Integer.MAX_VALUE-1;
        if(memo[idx][amount]!=-1) return memo[idx][amount];
        int take=Integer.MAX_VALUE;
        if(coins[idx]<=amount){
            take=1+findMinCoins(coins,idx,amount-coins[idx]);
        }
        int notTake=findMinCoins(coins,idx+1,amount);
        memo[idx][amount]=Math.min(take,notTake);
        return memo[idx][amount];

    }
    public int coinChange(int[] coins, int amount) {
        memo=new int[coins.length][amount+1];
        for(int m[]:memo){
            Arrays.fill(m,-1);
        }
        int totalcoins=findMinCoins(coins,0,amount);
        return totalcoins==Integer.MAX_VALUE-1?-1:totalcoins;
    }
    public static void main(String[] args) {
        int[] coins={1,2,5};
        int amount=11;
        System.out.println(new CointChange().coinChange(coins,amount));
        
        coins=new int[]{2};
        amount=3;
        System.out.println(new CointChange().coinChange(coins,amount));
        
        coins=new int[]{1};
        amount=0;
        System.out.println(new CointChange().coinChange(coins,amount));
        
        coins=new int[]{2,5,3,6};
        amount=10;
        System.out.println(new CointChange().coinChange(coins,amount));
        
        
    }
    
    
}
