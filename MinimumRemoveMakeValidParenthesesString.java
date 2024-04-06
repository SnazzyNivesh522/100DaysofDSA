/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
 */

import java.util.HashSet;
import java.util.Stack;

public class MinimumRemoveMakeValidParenthesesString {
    public String minRemoveToMakeValid(String s) {
        HashSet<Integer> closingIndex=new HashSet<>(); //invalid parenthese index
        Stack<Integer> stack=new Stack<>(); //push pop valid parenthes
        StringBuilder result=new StringBuilder();
        char []c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='('){
                stack.push(i);
            }
            else if(c[i]==')'){
                if(!stack.isEmpty()){
                    stack.pop(); //valid closing
                }
                else{
                    closingIndex.add(i); //not valid
                }
            }
        }
        //if stack is not empty then it means invalid parentheses remains    
        while(!stack.isEmpty()){
            closingIndex.add(stack.pop());
        }
        for(int i=0;i<c.length;i++){
            if(closingIndex.contains(i))
                continue;
            result.append(c[i]);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        MinimumRemoveMakeValidParenthesesString makeValid = new MinimumRemoveMakeValidParenthesesString();
        System.out.println(" lee(t(c)o)de) ->"+makeValid.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(" a)b(c)d ->"+makeValid.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(" ))(( ->"+makeValid.minRemoveToMakeValid("))(("));
        System.out.println(" () ->"+makeValid.minRemoveToMakeValid("()"));
        System.out.println(" ()( ->"+makeValid.minRemoveToMakeValid("()("));

    }

    
}