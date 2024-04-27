/*
 You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase occurrence of c appears before the first uppercase occurrence of c.

Return the number of special letters in word.

 

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

There are no special characters in word.

Example 3:

Input: word = "AbBCab"

Output: 0

Explanation:

There are no special characters in word.

 

Constraints:

1 <= word.length <= 2 * 105
word consists of only lowercase and uppercase English letters.

 */
import java.util.Arrays;

public class CountNumberofSpecialCharacters2 {
    public int numberOfSpecialChars(String word) {
        int lower[]=new int[26];
        int upper[]=new int[26];
        Arrays.fill(lower,-1);
        Arrays.fill(upper,-1);
        int special=0;
        int i=0;
        for(char c:word.toCharArray()){
            if(c>='a' && c<='z'){
                lower[c-'a']=i;
            }
            else{
                if(upper[c-'A']==-1){
                    upper[c-'A']=i;
                }
            }
            i++;
        }
        for(i=0;i<26;i++){
            if(lower[i]==-1 || upper[i]==-1) continue;
            if(lower[i]<upper[i]){                
                special++;
            }
        }
        return special;
    }
    public static void main(String[] args) {
        System.out.println(new CountNumberofSpecialCharacters2().numberOfSpecialChars("aaAbcBC")); 
        System.out.println(new CountNumberofSpecialCharacters2().numberOfSpecialChars("abc"));
        System.out.println(new CountNumberofSpecialCharacters2().numberOfSpecialChars("abBCab"));
        System.out.println(new CountNumberofSpecialCharacters2().numberOfSpecialChars("AbBCab"));
        System.out.println(new CountNumberofSpecialCharacters2().numberOfSpecialChars("cCceDC"));

    }
}
