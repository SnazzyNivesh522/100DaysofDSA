import java.util.HashSet;

public class LongestPalindrome {
    public int longestPalindrome(String s){
        HashSet<Character> oddSet=new HashSet<>();
        int len=0;
        for(char c:s.toCharArray()){
            if(!oddSet.contains(c)){
                oddSet.add(c);
            }
            else{
                oddSet.remove(c);
                len+=2;
            }
        }
        if(oddSet.isEmpty()) return len;
        return len+1;
    }
    // public int longestPalindrome(String s) {
    //     HashMap<Character,Integer> freqMap=new HashMap<>();
    //     for(char c:s.toCharArray()){
    //         freqMap.put(c,freqMap.getOrDefault(c,0)+1);
    //     }
    //     int len=0;
    //     int odd=0;
    //     for(int freq:freqMap.values()){
    //         if(freq%2==0){
    //             len+=freq;
    //         }
    //         else{
    //             len+=freq-1;
    //             odd=1;
    //         }
    //     }
    //     return len+odd;
    // }
}
