/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] charCount = new int[26];
        for(char c:s.toCharArray()){
            charCount[c-'a']++;
        }
        for(char c:t.toCharArray()){
            charCount[c-'a']--;
        }
        
        for(int cnt:charCount){
            if(cnt!=0) return false; //as -1 or 1 signifies occurs more or less times
        }
        return true;
    }
    public static void main(String[] args) {
        // test case from leetcode
        System.out.println((new ValidAnagram()).isAnagram("anagram", "nagaram"));
        System.out.println((new ValidAnagram()).isAnagram("rat", "car"));
        System.out.println((new ValidAnagram()).isAnagram("aacc", "ccac"));
    }
}
