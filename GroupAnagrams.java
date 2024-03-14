/*
 Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 */
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
