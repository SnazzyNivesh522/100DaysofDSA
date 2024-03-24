/*
You are given a string s and a character c. Return the total number of substrings of s that start and end with c.

 

Example 1:

Input: s = "abada", c = "a"

Output: 6

Explanation: Substrings starting and ending with "a" are: "abada", "abada", "abada", "abada", "abada", "abada".

Example 2:

Input: s = "zzz", c = "z"

Output: 6

Explanation: There are a total of 6 substrings in s and all start and end with "z".

 
 */
public class CountSubstringStrEndgivenCh {
    public long countSubstrings(String s, char c) {
        long temp=0;
        for(char t:s.toCharArray()){
            if(t==c){
                temp++;
            }
        }
        long count=temp*(temp+1)/2;
        return count;
        
    }
    public static void main(String[] args) {
        CountSubstringStrEndgivenCh cs = new CountSubstringStrEndgivenCh();
        System.out.println("Count of substring in eeeee with e is :"+cs.countSubstrings("eeeee", 'e'));
        System.out.println("Count of substring in zzz with z is :"+cs.countSubstrings("zzz", 'z'));
        System.out.println("Count of substring in abada with a is :"+cs.countSubstrings("abada", 'a'));
    } 
    
}
