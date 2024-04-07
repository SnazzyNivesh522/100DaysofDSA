/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.
 */

import java.util.Stack;

public class ValidParentheseString {
    public boolean checkValidString(String s) {
        Stack<Integer> stack=new Stack<>(); //push pop valid parentheses
        Stack<Integer> dummy=new Stack<>(); // * can behave as ( or )
        char c[]=s.toCharArray();
        boolean flag=true;
        for(int i=0;i<c.length;i++){
            if(c[i]=='('){
                stack.push(i);
            }
            else if(c[i]==')'){
                if(!stack.isEmpty()){
                    stack.pop(); //valid closing
                }
                else if(!dummy.isEmpty()){ 
                    dummy.pop(); //* behaves as (
                }
                else{
                    flag=false;
                    break;
                }
            }
            else if(c[i]=='*'){
                dummy.push(i);
            }
        }
        while(!stack.isEmpty() && !dummy.isEmpty()){
            int openindex=stack.pop();
            int dummyindex=dummy.pop();
            //)(==*(,)(==)*is not valid 
            if(dummyindex<openindex) {
                flag=false;
                break;
            }
                
        }
        if(!stack.isEmpty()) flag=false;
        return flag;
    }
    public static void main(String[] args) {
        ValidParentheseString vp = new ValidParentheseString();
        System.out.println("Valid String: " + vp.checkValidString("(*)"));//True
        System.out.println("Valid String: " + vp.checkValidString("()"));//True
        System.out.println("Valid String: " + vp.checkValidString("(*))"));//True
        System.out.println("Valid String: " + vp.checkValidString(")*"));//false
        System.out.println("Valid String: " + vp.checkValidString("*("));//False
        System.out.println("Valid String: " + vp.checkValidString("("));//false
    }

    
}