/*
Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.

 

Constraints:

1 <= hand.length <= 104
0 <= hand[i] <= 109
1 <= groupSize <= hand.length
 

Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/


 */

import java.util.Arrays;
import java.util.HashMap;

public class HandsOfStraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int handsize=hand.length;
        if(handsize%groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer,Integer> countMap=new HashMap<>();
        for(int h:hand){
            countMap.put(h,countMap.getOrDefault(h,0)+1);
        }
    
        for(int card:hand){
            if(countMap.get(card)>0){
                for(int i=0;i<groupSize;i++){
                    if(countMap.getOrDefault(card+i,0)==0){
                        return false;
                    }
                    countMap.put(card+i,countMap.get(card+i)-1);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int hand[]=new int[]{1,2,3,6,2,3,4,7,8};
        System.out.println(new HandsOfStraight().isNStraightHand(hand, 3));
        hand=new int[]{1,2,3,4,5};
        System.out.println(new HandsOfStraight().isNStraightHand(hand, 4));
        hand=new int[]{1,1,1,1,1};
        System.out.println(new HandsOfStraight().isNStraightHand(hand, 4));
    }

}
