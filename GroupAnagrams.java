import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> anagram_map=new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            char sort_str[]=strs[i].toCharArray();
            Arrays.sort(sort_str);
            if(!anagram_map.containsKey(String.valueOf(sort_str))){
                anagram_map.put(String.valueOf(sort_str),new ArrayList<String>());
                
            }
            anagram_map.get(String.valueOf(sort_str)).add(strs[i]);
            
        }
        return new ArrayList<>(anagram_map.values());
    }
    public static void main(String[] args) {
        GroupAnagrams  ga = new GroupAnagrams();
        String[] arr={"eat","tea","tan","ate","nat","bat"};
        System.out.println("Input:");
        System.out.println(Arrays.toString(arr));
        System.out.print("Output: "+ ga.groupAnagrams(arr)); 
    }
    
}
