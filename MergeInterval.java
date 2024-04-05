/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for (int[] interval : intervals) {
            int s=interval[0];
            int e=interval[1];
            if(s<=end){
                end=Math.max(end,e);
            }
            else{
                result.add(new int[]{start,end});
                start=s;
                end=e;
            }
        
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        MergeInterval mI = new MergeInterval();
        int[][] intervals=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println("After merging [[1,6],[8,10],[15,18]] becomes"); //[[1,6],[8,10],[15,18]]
        //print twod array using for loop @tabnine
        for (int[] interval : mI.merge(intervals)) {
            System.out.println(Arrays.toString(interval));
        }

        intervals=new int[][]{{1,4},{4,5}};
        System.out.println("\n\n[[1,4],[4,5]] becomes"); //[[1,4],[4,
        for (int[] interval : mI.merge(intervals)) {
            System.out.println(Arrays.toString(interval));
        }
    }
        
}
