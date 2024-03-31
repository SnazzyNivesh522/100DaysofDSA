/*
An integer divisible by the sum of its digits is said to be a Harshad number. You are given an integer x. Return the sum of the digits of x if x is a Harshad number, otherwise, return -1.

 

Example 1:

Input: x = 18

Output: 9

Explanation:

The sum of digits of x is 9. 18 is divisible by 9. So 18 is a Harshad number and the answer is 9.

Example 2:

Input: x = 23

Output: -1

Explanation:

The sum of digits of x is 5. 23 is not divisible by 5. So 23 is not a Harshad number and the answer is -1.
 */
public class HarshadNumber {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int num=x;
        int sum=0;
        int rem=0;
        while(x>0){
            rem=x%10;
            sum+=rem;
            x=x/10;
        }
        if(num%sum==0) return sum;
        return -1;
        
    }
    public static void main(String[] args) {
        HarshadNumber hn=new HarshadNumber();
        System.out.println("Sum of the digits of harshad number for "+18+" is :"+hn.sumOfTheDigitsOfHarshadNumber(18));
        System.out.println("Sum of digit for 23 : "+hn.sumOfTheDigitsOfHarshadNumber(23));
    }
}
