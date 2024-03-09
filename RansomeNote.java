import java.util.HashMap;

public class RansomeNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        // for(int i=0;i<ransomNote.length();i++){
        //     char r=ransomNote.charAt(i);
        //     int matchingIndex=magazine.indexOf(r);
        //     if(matchingIndex==-1){
        //         return false;
        //     }
        //     magazine=magazine.substring(0,matchingIndex) + magazine.substring(matchingIndex+1); 
        // }
        // return true;

        //HashMap solution
        if(magazine.length()<ransomNote.length()) return false;
        HashMap<Character, Integer> magazineLetters =new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char m=magazine.charAt(i);            
            int currCount=magazineLetters.getOrDefault(m,0);
            magazineLetters.put(m,currCount+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char r=ransomNote.charAt(i);            
             int currCount=magazineLetters.getOrDefault(r,0);
            if(currCount==0) return false;
            magazineLetters.put(r,currCount-1);
        }
        return true;

    }
    public static void main(String[] args) {
        RansomeNote obj= new RansomeNote();
        System.out.println("ransomNote =\r\n" + //
                        "\"aa\"\r\n" + //
                        "magazine =\r\n" + //
                        "\"aab\"\n"+obj.canConstruct("aa", "aab"));
    }
}