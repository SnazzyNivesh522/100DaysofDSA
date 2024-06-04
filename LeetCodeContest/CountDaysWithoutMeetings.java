import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        int freeDays=days;
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> newMeetings = new ArrayList<>();
        int start=meetings[0][0];
        int end=meetings[0][1];
        for (int meeting[]:meetings) {
            int s=meeting[0];
            int e=meeting[1];
            if(s<=end){
                end=Math.max(end,e);
            }
            else{
                newMeetings.add(new int[]{start,end});
                start=s;
                end=e;
            }
        
        }
        newMeetings.add(new int[]{start,end});
        for(int meeting[]:newMeetings){
            freeDays-=(meeting[1]-meeting[0]+1);            
        }
        return freeDays;
    }
}
