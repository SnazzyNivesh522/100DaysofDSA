/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 
*/

import java.util.ArrayList;

public class InsertIntervaltwoDArray {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // int[][] result=new int[intervals.length+1][2];
        ArrayList<int[]> result=new ArrayList<>();
        
        for(int []interval:intervals){
            int start=interval[0];
            int stop=interval[1];
            
            if(start>newInterval[1]){ //means newInterval will end before start of this
                result.add(newInterval);
                newInterval=interval;//added newInterval now need to comapre it to remaining      

            }
            else if(stop<newInterval[0]){ //interval ends before newInterval
                result.add(interval);
                
            }
            else{ //overlapping we will update start and stop of newInterval
                newInterval[0]=Math.min(newInterval[0],start);
                newInterval[1]=Math.max(newInterval[1],stop);
            }
        }
        result.add(newInterval);
        
        return result.toArray(new int[result.size()][]);
        
    }
    public static void main(String[] args) {
        InsertIntervaltwoDArray obj=new InsertIntervaltwoDArray();
        int result1[][]=obj.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
        System.out.println("intervals = [[1,3],[6,9]], newInterval = [2,5] result is");
        for (int i[] : result1) {
            System.out.print("{"+i[0]+","+i[1]+"}"+",");
        }
        int result2[][]=obj.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        System.out.println("\n\n\nintervals=[[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] result is");
        for (int i[] : result2) {
            System.out.print("{"+i[0]+","+i[1]+"}"+",");
        }
    }
    
}
