/*
 You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.

Return the score of s.

 

Example 1:

Input: s = "hello"

Output: 13

Explanation:

The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.

Example 2:

Input: s = "zaz"

Output: 50

Explanation:

The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.

 

Constraints:

2 <= s.length <= 100
s consists only of lowercase English letters.
 */
public class ScoreOfString {
    public int scoreOfString(String s) {
        int score=0;
        char c[]=s.toCharArray();
        for(int i=1;i<c.length;i++){
            score+=Math.abs(c[i]-c[i-1]);
        }
        return score;
    }
    public static void main(String[] args) {
        System.out.println("Score Of String Hello is "+new ScoreOfString().scoreOfString("hello"));
        System.out.println("Score Of String Zaz is "+new ScoreOfString().scoreOfString("zaz"));
        System.out.println("Score Of String Aa is "+new ScoreOfString().scoreOfString("aa"));
        System.out.println("Score Of String Zzz is "+new ScoreOfString().scoreOfString("zzz"));
    }
}
