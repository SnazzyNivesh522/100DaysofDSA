/*
The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
 

Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

 */

import java.util.HashMap;

public class NthTribonacciNumber {
    private HashMap<Integer,Integer> mem;
    private int M_TRIB(int n){
        if(mem.containsKey(n)){
            return mem.get(n);
        }
        int val=M_TRIB(n-3)+M_TRIB(n-2)+M_TRIB(n-1);
        mem.put(n,val);
        return val;
    }
    public int tribonacci(int n) {
        mem=new HashMap<>();
        mem.put(0,0);
        mem.put(1,1);
        mem.put(2,1);
        return M_TRIB(n);           
    }
    public static void main(String[] args) {
        System.out.println("4 : " + new NthTribonacciNumber().tribonacci(4)); 
        System.out.println("25 : " + new NthTribonacciNumber().tribonacci(25));
    }
    
}