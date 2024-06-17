/*
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false
 

Constraints:

0 <= c <= 231 - 1
 */
public class SumofSquareNumbers {
    // consider a array of X^2 where X belongs to [0,sqrt(C)]
    // we can keep two pointers and find the solution
    public boolean judgeSquareSum(int c){
        long left=0;
        long right=(int)Math.sqrt(c);
        while(left<=right){
            long target=left*left+right*right;
            if(target>c){
                right--;
            }
            else if(target<c){
                left++;
            }
            else{
                return true;
            }
        }
        return false;

    }
    //time complexity O(Sqrt(C))
    // public boolean judgeSquareSum(int c){
    //     int limit = (int) Math.sqrt(c);
    //     HashSet<Integer> perfectSquares = new HashSet<Integer>();
    //     for (int i = 0; i <= limit; i++) {
    //         perfectSquares.add(i * i);
    //     }
    //     for (int a = 0; a <= limit; a++) {
    //         if (perfectSquares.contains(c - a * a)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    //brute - force O(C)
    // public boolean judgeSquareSum(int c) {
    //     for (long a = 0; a * a <= c; a++) {
    //         for (long b = 0; b * b <= c; b++) {
    //             if (a * a + b * b == c) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    public static void main(String[] args) {
        SumofSquareNumbers s = new SumofSquareNumbers();
        System.out.println(s.judgeSquareSum(5));
        System.out.println(s.judgeSquareSum(3));
        System.out.println(s.judgeSquareSum(4));
        System.out.println(s.judgeSquareSum(8));
        System.out.println(s.judgeSquareSum(9));
        System.out.println(s.judgeSquareSum(2147482647));
        System.out.println(s.judgeSquareSum(2147483646));
        System.out.println(s.judgeSquareSum(2147483600));
    }
}
