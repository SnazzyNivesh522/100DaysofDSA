/*
 You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

 

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
 */
public class MergeStringsAlternate {
    public String mergeAlternately(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        String word="";
        int i,j;
        i=j=0;
        while(i<m && j<n){
            
                word+=word1.charAt(i);                
                i++;            
            
                word+=word2.charAt(j);
                j++;
            
        }
        while(i<m){
            word+=word1.charAt(i);
            i++;
        }
        while(j<n){
            word+=word2.charAt(j);
            j++;
        }
        return word;

    }
    public static void main(String[] args) {
        MergeStringsAlternate ms = new MergeStringsAlternate();
        String word1="abc";
        String word2="pr";
        System.out.println(ms.mergeAlternately(word1, word2));
    }
    
}
