/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */

import java.util.Stack;

public class RemoveKDigitsStack {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0"; 
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char n:num.toCharArray()){
            //if right is less than all the left ones then we dont need them(greedy)
            while(!stack.isEmpty() && k>0){
                if(stack.peek()>n){
                    stack.pop();
                    k--;
                }
                else break;
            }
            stack.push(n);
        }
        //if all or remaining digits are monotonic
        while(k>0){
            stack.pop();
            k--;
        }
        //need to remove zero from prefix
        boolean prefix=true;
        for(char number:stack){
            if(prefix && number=='0') continue;
            prefix=false; //as now zero may occure in between
            result.append(number);
        }
        if(result.length()==0) return "0";
        return result.toString();
    }
    public static void main(String[] args) {
        RemoveKDigitsStack rkd = new RemoveKDigitsStack();
        System.out.println(rkd.removeKdigits("1432219", 3));
        System.out.println(rkd.removeKdigits("10200", 1));
        System.out.println(rkd.removeKdigits("10", 2));
        System.out.println(rkd.removeKdigits("0", 1));
        System.out.println(rkd.removeKdigits("10", 1));
    }
    
}