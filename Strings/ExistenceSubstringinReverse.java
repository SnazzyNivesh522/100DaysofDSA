/*
Given a string s, find any substring of length 2 which is also present in the reverse of s.

Return true if such a substring exists, and false otherwise.

 

Example 1:

Input: s = "leetcode"

Output: true

Explanation: Substring "ee" is of length 2 which is also present in reverse(s) == "edocteel".

Example 2:

Input: s = "abcba"

Output: true

Explanation: All of the substrings of length 2 "ab", "bc", "cb", "ba" are also present in reverse(s) == "abcba".

Example 3:

Input: s = "abcd"

Output: false

Explanation: There is no substring of length 2 in s, which is also present in the reverse of s. 
*/
public class ExistenceSubstringinReverse {
    public boolean isSubstringPresent(String s) {
        if (s.length()<2) {
            return false;
        }
        StringBuilder temp=new StringBuilder(s);
        temp.reverse();
        String reversed=temp.toString();
        for(int i=0;i<s.length()-1;i++){
            String substring=s.substring(i,i+2);
            if(reversed.contains(substring)){
                return true;
            }
        }
        return false;
        
        
    }
    public static void main(String[] args) {
        ExistenceSubstringinReverse obj = new ExistenceSubstringinReverse();
        System.out.println("Existence of substring in reverse of leetcode: "+obj.isSubstringPresent("leetcode"));
        System.out.println("Existence of substring in reverse of abcba: "+obj.isSubstringPresent("abcba"));
        System.out.println("Existence of substring in reverse of abcd: "+obj.isSubstringPresent("abcd"));
    }
   
}
