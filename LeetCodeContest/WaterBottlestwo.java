
/*
You are given two integers numBottles and numExchange.

numBottles represents the number of full water bottles that you initially have. In one operation, you can perform one of the following operations:

Drink any number of full water bottles turning them into empty bottles.
Exchange numExchange empty bottles with one full water bottle. Then, increase numExchange by one.
Note that you cannot exchange multiple batches of empty bottles for the same value of numExchange. For example, if numBottles == 3 and numExchange == 1, you cannot exchange 3 empty water bottles for 3 full bottles.

Return the maximum number of water bottles you can drink.

 

Example 1:


Input: numBottles = 13, numExchange = 6
Output: 15
Explanation: The table above shows the number of full water bottles, empty water bottles, the value of numExchange, and the number of bottles drunk.
 * This table tracks the number of bottles a person drinks.
 *
 * Full Bottles  Empty Bottles  numExchange  Bottles Drunk
 * ----------  --------------  ------------  --------------
 * 10            0               0             0
 * 0             10              10            10
 * 1             7               4             10
 * 2             3               5             10
 * 0             5               5             12
 * 1             0               6             12

Example 2:
Input: numBottles = 10, numExchange = 3
Output: 13
Explanation: The table above shows the number of full water bottles, empty water bottles, the value of numExchange, and the number of bottles drunk.

 * This table tracks the number of bottles a person drinks.
 *
 * Full Bottles  Empty Bottles  numExchange  Bottles Drunk
 * ----------  --------------  ------------  --------------
 * 10            0               0             0
 * 0             10              10            10
 * 1             7               4             10
 * 2             3               5             10
 * 0             5               5             12
 * 1             0               6             12
 * 0             1               6             13
  
*/

public class WaterBottlestwo {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty=numBottles;
        int bottlesDrunk=numBottles;
        numBottles=0;
        while(empty>=numExchange){
            empty-=numExchange;
            numExchange++;
            empty++;
            bottlesDrunk++;           
            
        }
        return bottlesDrunk;
    }
    public static void main(String[] args) {
        WaterBottlestwo wb = new WaterBottlestwo();
        System.out.println("Number of bottlesDrunk are " +wb.maxBottlesDrunk(10,3));
        System.out.println("Number of bottlesDrunk are " +wb.maxBottlesDrunk(13,6));
    }    
}
