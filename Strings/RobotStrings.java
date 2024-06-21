/*
There are three robots named Ray, Ben and Kevin. Initially Ray has a string S of length N.
while the other two robots have empty strings. We can make either of the following moves:

    Move 1: Remove the first character from Ray's string and append it to Ben's string.

    Move 2: Remove the last character from Ben's string and append it to Kevin's string.

You must perform either of the two moves mentioned above in such a way that 
the strings left with Ray and Ben are empty and the string left with Kevin is lexicographically the smallest. 
Your task is to return this lexicographically smallest string that Kevin has after completing this activity.
*/
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Stack;
public class RobotStrings
{
    private static String robotStrings(String Ray,String Ben,String Kevin){
        int n=Ray.length();
        // Stack<Character> stack=new Stack<>();
        Stack<Character> benst=new Stack<>();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int idx=0;
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty() || Ray.charAt(i)<=stack.peek()){
                stack.offer(Ray.charAt(i));
                
            }
        }
        while(idx<n && !stack.isEmpty()){
            benst.push(Ray.charAt(idx++));
            if(Objects.equals(benst.peek(), stack.peek())){
                sb.append(benst.pop());
                stack.pop();
                while(!benst.empty() && !stack.isEmpty() && benst.peek()<=stack.peek()){
                    sb.append(benst.pop());
                }
            }
        }
        while(!benst.empty()){
            sb.append(benst.pop());
        }
        Kevin=sb.toString();
        System.out.print(Ray+": ");
        return Kevin;
        
    }
	public static void main(String[] args) {
		String Ray1 = "cba";
        String Ray2 = "dad";
        String Ray3 = "gdfedabcdae";
        String Ray4 = "orcbagb";
        System.out.println(robotStrings(Ray1, "", ""));
        System.out.println(robotStrings(Ray2, "", "")); 
        System.out.println(robotStrings(Ray3, "", "")); 
        System.out.println(robotStrings(Ray4, "", ""));
        String Ray5 = "pragya";
        System.out.println(robotStrings(Ray5, "", ""));
	}
}
