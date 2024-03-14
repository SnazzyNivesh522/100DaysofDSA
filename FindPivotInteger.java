/*
 Given a positive integer n, find the pivot integer x such that:

The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.

 

Example 1:

Input: n = 8
Output: 6
Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 is the pivot integer since: 1 = 1.
Example 3:

Input: n = 4
Output: -1
Explanation: It can be proved that no such integer exist.
 */
import java.util.Scanner;

public class FindPivotInteger {
    public int pivotInteger(int n) {
        int left=1;
        int right=n;

        int sum=n*(n+1)/2;
        while(left<=right){
            int mid=(left+right)/2;
            //sum from 1->mid
            int sumMid=mid*(mid+1)/2;

            //sum from mid->n
            int sumNmid=sum-sumMid+mid;
            if(sumNmid==sumMid){
                return mid;
            }
            else if(sumNmid>sumMid){
                left=mid+1;
            }
            else{
                right=mid-1;
            }

        }
        return -1;
        
    }
    public static void main(String[] args) {
        FindPivotInteger fpi = new FindPivotInteger();
        System.out.println();
        System.out.println("Input number:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("The Pivot Integer is : " + fpi.pivotInteger(num));
        scanner.close();
    }
    
    
}
