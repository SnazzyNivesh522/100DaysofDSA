/*
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

 

Example 1:

Input: n = 5
Output: true
Explanation: The binary representation of 5 is: 101
Example 2:

Input: n = 7
Output: false
Explanation: The binary representation of 7 is: 111.
Example 3:

Input: n = 11
Output: false
Explanation: The binary representation of 11 is: 1011.
 

Constraints:

1 <= n <= 2^31 - 1
 */
public class BinaryNumberAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int x=n>>1;
        if (n>=1){
            n=n^x;
            x=n+1;
            if((x&n)==0) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        BinaryNumberAlternatingBits obj=new BinaryNumberAlternatingBits();
        System.out.println(obj.hasAlternatingBits(5));
        System.out.println(obj.hasAlternatingBits(7));
        System.out.println(obj.hasAlternatingBits(11));
        System.out.println(obj.hasAlternatingBits(10));
        System.out.println(obj.hasAlternatingBits(1));
        System.out.println(obj.hasAlternatingBits(1000));
        System.out.println(obj.hasAlternatingBits(8));
        
    }
    
}
