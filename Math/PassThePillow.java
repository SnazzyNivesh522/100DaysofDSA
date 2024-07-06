/*
There are n people standing in a line labeled from 1 to n. The first person in the line is holding a pillow initially. Every second, the person holding the pillow passes it to the next person standing in the line. Once the pillow reaches the end of the line, the direction changes, and people continue passing the pillow in the opposite direction.

For example, once the pillow reaches the nth person they pass it to the n - 1th person, then to the n - 2th person and so on.
Given the two positive integers n and time, return the index of the person holding the pillow after time seconds.

 

Example 1:

Input: n = 4, time = 5
Output: 2
Explanation: People pass the pillow in the following way: 1 -> 2 -> 3 -> 4 -> 3 -> 2.
After five seconds, the 2nd person is holding the pillow.
Example 2:

Input: n = 3, time = 2
Output: 3
Explanation: People pass the pillow in the following way: 1 -> 2 -> 3.
After two seconds, the 3rd person is holding the pillow.
 

Constraints:

2 <= n <= 1000
1 <= time <= 1000
 */
public class PassThePillow {
    // Math O(1)
    public int passThePillow(int n, int time) {
        int completerRounds = time / (n - 1);
        int remainingTime = time % (n - 1);
        if (completerRounds % 2 == 0) { // means we are now to start from 1st
            return remainingTime + 1;
        } else { //starting from last n
            return n - remainingTime;
        }
    }
    // Simulation - O(n)
    // public int passThePillow(int n, int time) {
    // int direction=1;
    // int i=1;
    // while(time>0){
    // i+=direction;
    // time--;
    // if(i==n){
    // direction=-1;
    // }
    // if(i==1){
    // direction=1;
    // }
    // }
    // return i;
    // }
    public static void main(String[] args) {
        PassThePillow p = new PassThePillow();
        System.out.println(p.passThePillow(4, 5));
        System.out.println(p.passThePillow(3, 2));
        System.out.println(p.passThePillow(6, 3));
        System.out.println(p.passThePillow(1000, 1000));
    }
}
