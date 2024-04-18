/*
Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters

Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index ).


Example 1:

Input:
S = "aaaabbaa"
Output:
aabbaa
Explanation:
The longest palindrome string present in
the given string is "aabbaa".

Your Task:  
You don't need to read input or print anything. Your task is to complete the function longestPalindrome() which takes string S as input parameters and returns longest pallindrome present in string.


Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ |S| ≤ 104


 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n=s.length();
        int start=0;
        int end=0;
        for(int mid=0;mid<n;mid++){
            //odd cases
            int low=mid-1;
            int high=mid+1;
            while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                if((high-low+1)>end-start+1){
                    start=low;
                    end=high;
                }
                low--;
                high++;
            }
            //even cases
            low=mid-1;
            high=mid;
            while(low>=0 && high<n && s.charAt(low)==s.charAt(high)){
                if((high-low + 1)>end-start+1){
                    start=low;
                    end=high;
                }
                low--;
                high++;
            }
        }
        return s.substring(start,end+1);          
    }
    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindrome("abbaa"));
        System.out.println(lps.longestPalindrome("abbaaabbaa"));
        System.out.println(lps.longestPalindrome("abbaaabbaaabbaa"));
        System.out.println(lps.longestPalindrome("abbaaabbaaabbaaabbaa"));
        System.out.println(lps.longestPalindrome("racecar"));
        System.out.println(lps.longestPalindrome("babad"));
        System.out.println(lps.longestPalindrome("cbbd"));
    }
}
