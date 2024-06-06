/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */

public class ReverseWordsInAString {
    // public String reverseWords(String s) {
    //     Stack<String> stack = new Stack<>();
    //     StringBuilder word = new StringBuilder();
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == ' ') {
    //             if (word.length() > 0) {
    //                 stack.push(word.toString());
    //                 word.setLength(0); // Reset the word
    //             }
    //         } else {
    //             word.append(s.charAt(i));
    //         }
    //     }
    //     if (word.length() > 0) {
    //         stack.push(word.toString());
    //     }
    //     StringBuilder result = new StringBuilder();
    //     while (!stack.isEmpty()) {
    //         result.append(stack.pop());
    //         if (!stack.isEmpty()) {
    //             result.append(" ");
    //         }
    //     }
    //     return result.toString();
    // }

    public int removeMultipleSpaces(char[] s) {
        int i = 0, j = 0, n = s.length;
        while (j < n) {
            while (j < n && s[j] == ' ') {
                j++;
            }
            while (j < n && s[j] != ' ') {
                s[i] = s[j];
                i++;
                j++;
            }
            while (j < n && s[j] == ' ') {
                j++;
            }
            if (j < n) {
                s[i] = ' ';
                i++;
            }

        }
        return i;
    }

    public void reverseWord(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public String reverseWords(String s) {
        char str[] = s.toCharArray();
        reverseString(str);
        int i = 0, j = 0;
        int n = str.length;
        while (i < n - 1 || j < n - 1) {
            while (j < n - 1 && str[j + 1] != ' ') {
                j++;
            }
            reverseWord(str, i, j);
            i = j;
            while (i < n - 1 && str[i + 1] == ' ') {
                i++;
            }
            j = i;
            i++;
        }
        int slice = removeMultipleSpaces(str);
        return new String(str).substring(0, slice);
    }
    public static void main(String[] args) {
        //test cases
        ReverseWordsInAString obj=new ReverseWordsInAString();
        System.out.println(obj.reverseWords("the sky is blue"));
        System.out.println(obj.reverseWords("  hello world  "));
        System.out.println(obj.reverseWords("a good   example"));
        System.out.println(obj.reverseWords("  Bob    Loves  Alice   "));
        System.out.println(obj.reverseWords("Alice does not even like bob"));
        System.out.println(obj.reverseWords("I Love To Code"));
        System.out.println(obj.reverseWords("Alice likes  bob"));
        System.out.println(obj.reverseWords("Alice likes  bob "));
        System.out.println(obj.reverseWords("Alice likes  bob  "));
        System.out.println(obj.reverseWords("data structures and algorithms"));
        System.out.println(obj.reverseWords("  Leetcode is  fun "));
    }
}
