import java.util.PriorityQueue;

public class LexicographicallyMinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->{
            if(s.charAt(a) == s.charAt(b)) {
                return b-a;
            }
            else {
                return s.charAt(a) - s.charAt(b);
            }
        });
        StringBuilder str=new StringBuilder(s);
        int n=s.length();
        for(int right=0;right<n;right++){
            if(str.charAt(right)!='*'){
                heap.offer(right);
            }
            else{
                if(!heap.isEmpty()){
                    int idx=heap.poll();
                    str.setCharAt(idx,'1');  
                }                   
            }
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<n;i++){
            if(str.charAt(i)!='1' && str.charAt(i)!='*'){
                result.append(str.charAt(i));
            }
        }
        return result.toString();        
    }
}
