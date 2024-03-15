/*
 Assume you have an array of length n initialized with all 0’s and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex … endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]
Explanation:

Initial state:
[ 0, 0, 0, 0, 0 ]

After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]

After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]

After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]
 */

import java.util.Arrays;

public class RangeAdditionArray {
    public int[] getModifiedArray(int length, int[][] updates) {
        int []modified =new int[length];
        Arrays.fill(modified, 0);
        for (int i=0;i<updates.length;i++){
            modified[updates[i][0]]+=updates[i][2];
            if(updates[i][1]+1<length){
                modified[updates[i][1]+1]-=updates[i][2];
            }
        }
        for (int i=1;i<length;i++){
            modified[i]+=modified[i-1];

        }
        return  modified;
    }
    
    public static void main(String[] args) {
        RangeAdditionArray raa = new RangeAdditionArray();
        System.out.println(Arrays.toString(raa.getModifiedArray(5, new int[][]{
            {1,  3,  2},
            {2,  4,  3},
            {0,  2, -2}})
        ));
        
    }
    
}
