/*
Given a string S of size N consisting of the characters 0, 1 and 2, the task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.

Examples:

Input: S = “01212”
Output: 3
Explanation: The substring 012 is the smallest substring
that contains the characters 0, 1 and 2.

Input:  S = “12121”
Output: -1
Explanation:  As the character 0 is not present in the
string S, therefore no substring containing
all the three characters 0, 1 and 2
exists. Hence, the answer is -1 in this case.
 */

public class SmallestWindowContaining012 {

    public static int smallestSubstring(String S) {
        int n = S.length();
        int freq[]=new int[3];
        int left=0;
        int window=-1;          
        for(int right=0;right<n;right++){
            if(S.charAt(right)=='0'){
                freq[0]++;
            }
            if(S.charAt(right)=='1'){
                freq[1]++;
            }
            if(S.charAt(right)=='2'){
                freq[2]++;
            }
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                if(window==-1){
                    window=right-left+1;
                }
                else{
                    window=Math.min(window,right-left+1);
                }
                freq[S.charAt(left)-'0']--;
                left++;
            }
        }
        return window;
    }

    public static void main(String[] args) {
        String str1 = "01212";
        String str2 = "12121";
        String str3= "1210";
        String str="012";
        System.out.println("Smallest window in " + str + " is: " + smallestSubstring(str));
        System.out.println("Smallest window in " + str1 + " is: " + smallestSubstring(str1));
        System.out.println("Smallest window in " + str2 + " is: " + smallestSubstring(str2));
        System.out.println("Smallest window in " + str3 + " is: " + smallestSubstring(str3));
    }
}

