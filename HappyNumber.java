/*
 Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 

Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        //using same floyd tortoise and hare as in linked list cycle

        int slow=n,fast=n;
        do{
            slow=sumofSquares(slow);
            fast=sumofSquares(fast);
            fast=sumofSquares(fast);
        }while(slow!=fast);
        //above breaks when both becomes equal
        //if 1 we need then true else false
        if(slow==1)
            return true;
        return false;
        
    }
    public static int sumofSquares(int num){
        int sum=0,digit;
        do{
            digit=num%10;
            sum+=digit*digit;
            num/=10;
        }while(num>0);
        return sum;
    }
    public static void main(String[] args) {
        int number=19;
        if(isHappy(number))
            System.out.println(number+" is happy number ");
        else
            System.out.println(number+" is not happy number ");
        number=2;
        if(isHappy(number))
            System.out.println(number+" is happy number ");
        else
            System.out.println(number+" is not happy number ");
    }
}
