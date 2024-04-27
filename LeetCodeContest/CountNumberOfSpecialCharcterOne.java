/*
You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

Return the number of special letters in word.

 

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters in word are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

No character in word appears in uppercase.

Example 3:

Input: word = "abBCab"

Output: 1

Explanation:

The only special character in word is 'b'.

 

Constraints:

1 <= word.length <= 50
word consists of only lowercase and uppercase English letters.

 */



public class CountNumberOfSpecialCharcterOne {
    public int numberOfSpecialChars(String word) {
        int lower[]=new int[26];
        int upper[]=new int[26];
        int special=0;
        for(char c:word.toCharArray()){
            if(c>='a' && c<='z'){
                lower[c-'a']=1;
            }
            else{
                upper[c-'A']=1;
            }
        }
        for(int i=0;i<26;i++){
            if(lower[i]==1 && upper[i]==1){
                special++;
            }
        }
        return special;
       
        // Set<Character> lowercase = new HashSet<>();
        // Set<Character> uppercase = new HashSet<>();
        
        // for (char c : word.toCharArray()) {
        //     if (Character.isLowerCase(c)) {
        //         lowercase.add(c);
        //     } else {
        //         uppercase.add(Character.toLowerCase(c));
        //     }
        // }
        
        // lowercase.retainAll(uppercase);
        // return lowercase.size();
    }
    public static void main(String[] args) {
        System.out.println(new CountNumberOfSpecialCharcterOne().numberOfSpecialChars("aaAbcBC"));
        System.out.println(new CountNumberOfSpecialCharcterOne().numberOfSpecialChars("abc"));
        System.out.println(new CountNumberOfSpecialCharcterOne().numberOfSpecialChars("abBCab"));
        System.out.println(new CountNumberOfSpecialCharcterOne().numberOfSpecialChars("AAaAbcABC"));

    }
}
