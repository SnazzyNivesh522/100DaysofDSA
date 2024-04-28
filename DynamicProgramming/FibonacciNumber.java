/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

 

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Constraints:

0 <= n <= 30
 */


import java.util.HashMap;

/**
 * FibonacciNumber
 */
public class FibonacciNumber {
    private HashMap<Integer,Integer> mem;
    private int M_FIB(int n){
        if(mem.containsKey(n)){
            return mem.get(n);
        }
        int val=M_FIB(n-1)+M_FIB(n-2);
        mem.put(n,val);
        return val;
    }
    public int fib(int n) {
        mem=new HashMap<>();
        mem.put(0,0);
        mem.put(1,1);
        return M_FIB(n); 
        
    }
    public static void main(String[] args) {
        System.out.println("Fibonacci Number for n=2 : "+ ( new FibonacciNumber().fib(2)));
        System.out.println("Fibonacci Number for n=3 : "+ ( new FibonacciNumber().fib(3)));
        System.out.println("Fibonacci Number for n=4 : "+ ( new FibonacciNumber().fib(4)));
        System.out.println("Fibonacci Number for n=5 : "+ ( new FibonacciNumber().fib(5)));
    }
    
}