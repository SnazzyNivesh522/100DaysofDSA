/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 */
import java.util.Arrays;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] st = new int[256];
        int[] ts = new int[256]; 
        Arrays.fill(st,-1);
        Arrays.fill(ts,-1);       
        for(int i=0; i<s.length(); i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(st[c1]==-1 && ts[c2]==-1){
                st[c1]=c2;
                ts[c2]=c1;
            }
            else if(!(st[c1]==c2 && ts[c2]==c1)){
                return false;
            }           
        }
        return true;
    
    }
    public static void main(String[] args) {
        IsomorphicStrings is=new IsomorphicStrings();
        System.out.println(is.isIsomorphic("egg","add"));
        System.out.println(is.isIsomorphic("foo","bar"));
        System.out.println(is.isIsomorphic("paper","title"));
        System.out.println(is.isIsomorphic("ab","aa"));
        System.out.println(is.isIsomorphic("badc","baba"));
    }
    
}
