/*
Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
public class MaxProfitBuySellStock {
    public int maxProfit(int[] prices) {
        //TC O(n^2) Time limit excedded
        // int maxprofit=0;
        // for(int i=0;i<prices.length;i++){
        //     for(int j=i+1;j<prices.length;j++){
        //         maxprofit=Math.max(maxprofit,prices[j]-prices[i]);
        //     }
        // }
        // return maxprofit;

        int buyprice=prices[0];
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<buyprice) {
                buyprice=prices[i];
            } 
            maxprofit=Math.max(maxprofit,prices[i]-buyprice);
            // else if (prices[i]-buyprice>maxprofit) {
            //     maxprofit=prices[i]-buyprice;
            // }
            
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        MaxProfitBuySellStock stocks=new MaxProfitBuySellStock();
        System.out.println(stocks.maxProfit(new int[]{7,1,5,3,6,4}));//Expected output : 5
        System.out.println(stocks.maxProfit(new int[]{7,6,4,3,1}));//Expected output : 0
        System.out.println(stocks.maxProfit(new int[]{100,180,260,310,40,535,695}));//Expected output : 655
        System.out.println(stocks.maxProfit(new int[]{4,2,2,2,4}));//Expected output : 2

    }
    
}
