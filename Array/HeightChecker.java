/*
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

 

Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
Example 2:

Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.
Example 3:

Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.
 

Constraints:

1 <= heights.length <= 100
1 <= heights[i] <= 100
 */
import java.util.HashMap;

public class HeightChecker {
    private int countSort(int arr[],int heights[]){
        HashMap<Integer,Integer> countMap=new HashMap<>();
        int minVal=Integer.MAX_VALUE;
        int maxVal=Integer.MIN_VALUE;
        for(int a:arr){
            minVal=Math.min(minVal,a);
            maxVal=Math.max(maxVal,a);
            countMap.put(a,countMap.getOrDefault(a,0)+1);
        }
        int i=0;
        int count=0;
        for(int val=minVal;val<=maxVal;val++){
            while(countMap.getOrDefault(val,0)>0){
                arr[i]=val;
                if(val!=heights[i]) count++;
                i++;
                countMap.put(val,countMap.get(val)-1);
            }
        }
        return count;
    }
    public int heightChecker(int[] heights) {
        int expected[] = heights.clone();
        int count=countSort(expected,heights);
        // int count = 0;
        // for (int i = 0; i < n; i++) {
        //     if (expected[i] != heights[i]) {
        //         count++;
        //     }
        // }
        return count;
    }
    public static void main(String[] args) {
        int heights[]=new int[]{1,1,4,2,1,3};
        System.out.println(new HeightChecker().heightChecker(heights));
        heights=new int[]{5,1,2,3,4};
        System.out.println(new HeightChecker().heightChecker(heights));

    }
}
