/*
The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.

The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:

If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
Otherwise, they will leave it and go to the queue's end.
This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.

 

Example 1:

Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0 
Explanation:
- Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
- Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
- Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
- Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
- Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
Hence all students are able to eat.
Example 2:

Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
Output: 3
 

Constraints:

1 <= students.length, sandwiches.length <= 100
students.length == sandwiches.length
sandwiches[i] is 0 or 1.
students[i] is 0 or 1.
 */

import java.util.LinkedList;
import java.util.Queue;

public class NumStudentsUnableEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        //0-CIRCULAR sandwiches
        //1-SQUARE sandwiches
        int n=students.length;
        int top=0;//
        Queue<Integer> queue=new LinkedList<>();
        // Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            queue.add(students[i]);
            // stack.push(sandwiches[n-i-1]);//reverse order we need to place first sandwich at top
        }
        int remaining=0;
        while(!queue.isEmpty() && remaining<queue.size()){
            // if(stack.peek()==queue.peek()){
            //     stack.pop();
            //     queue.remove();
            //     remaining=0;
            // }
            if(sandwiches[top]==queue.peek()){
                top++;
                queue.remove();
                remaining=0;
            }
            else{
                queue.add(queue.remove());
                remaining++;
            }
        }
        return queue.size();        
    }
    public static void main(String[] args) {
        NumStudentsUnableEatLunch obj=new NumStudentsUnableEatLunch();
        System.out.println("result is "+obj.countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1}));
        System.out.println("result is "+obj.countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
        System.out.println("result is "+obj.countStudents(new int[]{1,1,1,1,0,0,0,0}, new int[]{0,1,0,1,0,1,0,1,0,1}));
                
    }
    
}
