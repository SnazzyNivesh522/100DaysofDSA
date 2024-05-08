/*
You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.

 

Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
Example 2:

Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].

 

Constraints:

n == score.length
1 <= n <= 104
0 <= score[i] <= 106
All the values in score are unique.

 */
package Heaps_PriorityQueue;

import java.util.PriorityQueue;

public class RelativeRanks {
   public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        PriorityQueue<Pair<Integer,Integer>> heap=new PriorityQueue<>((a,b)->b.getKey()-a.getKey());
        for(int i=0;i<n;i++){
            heap.add(new Pair<>(score[i],i));
        }
        String []ranks=new String[n];
        int pos=1;
        while(!heap.isEmpty()){
            Pair<Integer,Integer> curr=heap.poll();
            int idx=curr.getValue();
            if(pos==1){
                ranks[idx]="Gold Medal";
            }
            else if(pos==2){
                ranks[idx]="Silver Medal";
            }
            else if(pos==3){
                ranks[idx]="Bronze Medal";
            }
            else{
                ranks[idx]=String.valueOf(pos);
            }
            pos++;
        }
        return ranks;
    }
    public static void main(String[] args) {
        RelativeRanks rr = new RelativeRanks();
        int[] score = {5,4,3,2,1};
        System.out.println("Output: "+java.util.Arrays.toString(rr.findRelativeRanks(score)));
        score = new int[]{10,3,8,9,4};
        System.out.println("\n\nInput: [10,3,8,9,4]");
        System.out.print("Output: ");
        System.out.println(java.util.Arrays.toString(rr.findRelativeRanks(score)));
    } 
}
