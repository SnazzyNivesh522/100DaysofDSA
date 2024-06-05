import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacter {
    public List<String> commonChars(String[] words) {
        List<String> common=new ArrayList<>();
        int commonfreq[]=new int[26];
        int currentfreq[]=new int[26];

        for(char ch:words[0].toCharArray()){
            commonfreq[ch-'a']++;
        }
        for(int i=1;i<words.length;i++){
            Arrays.fill(currentfreq,0);
            for(char ch:words[i].toCharArray()){
                currentfreq[ch-'a']++;
            }
            for(int c=0;c<26;c++){
                commonfreq[c]=Math.min(commonfreq[c],currentfreq[c]);
            }
        }
        for(int c=0;c<26;c++){
            for(int freq=0;freq<commonfreq[c];freq++){
                common.add(Character.toString((char)(c+'a')));
            }
        }
        return common;
    }
    public static void main(String[] args) {
        String words[]=new String[]{"bella","label","roller"};
        System.out.println(new FindCommonCharacter().commonChars(words));

        words=new String[]{"cool","lock","cook"};
        System.out.println(new FindCommonCharacter().commonChars(words));

        words=new String[]{"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
        System.out.println(new FindCommonCharacter().commonChars(words));

       



    }
}
