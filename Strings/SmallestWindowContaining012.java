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

import java.util.Arrays;

public class SmallestWindowContaining012 {

    public static int findSmallestWindow(String str) {
        int n = str.length();

        // Arrays to store the first occurrences of characters 0, 1 and 2
        int[] firstIndex = new int[3];
        Arrays.fill(firstIndex, -1);

        // Variable to store the current window end index
        int currEnd = 0;

        // Minimum window length seen so far
        int minWindowLen = Integer.MAX_VALUE;

        // Traverse the string
        for (int i = 0; i < n; i++) {
            char charAtI = str.charAt(i);

            // Update the first occurrence of the current character
            firstIndex[charAtI - '0'] = i;

            // Slide the window until all characters are found
            while (hasAllChars(firstIndex)) {
                // Update the minimum window length
                minWindowLen = Math.min(minWindowLen, i - currEnd + 1);

                // Slide the window by incrementing the start index
                currEnd++;
            }
        }

        // Return -1 if no window is found
        return minWindowLen == Integer.MAX_VALUE ? -1 : minWindowLen;
    }

    // Check if all characters (0, 1 and 2) have a valid first occurrence
    private static boolean hasAllChars(int[] firstIndex) {
        for (int i : firstIndex) {
            if (i == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "01212";
        String str2 = "12121";

        System.out.println("Smallest window in " + str1 + " is: " + findSmallestWindow(str1));
        System.out.println("Smallest window in " + str2 + " is: " + findSmallestWindow(str2));
    }
}

