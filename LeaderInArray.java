/*
Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is a leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader. 

Example 1:

Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17 
as it is greater than all the elements
to its right.  Similarly, the next 
leader is 5. The right most element 
is always a leader so it is also 
included.
Example 2:

Input:
n = 5
A[] = {1,2,3,4,0}
Output: 4 0
Explanation: 0 is the rightmost element
and 4 is the only element which is greater
than all the elements to its right.
 */

import java.util.ArrayList;
import java.util.Collections;

public class LeaderInArray {
    static ArrayList<Integer> leaders(int arr[], int n){
        int max=arr[n-1];
        ArrayList<Integer> result = new ArrayList<>();
        for (int right= n-1;right>=0;right--){
            if (arr[right]>=max){           
                max= arr[right];
                result.add(max);
            }
        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] args) {
        int A[] ={16,17,4,3,5,2};
        System.out.println(leaders(A,A.length));
        A=new int[] {1,2,3,4,0};
        System.out.println(leaders(A,A.length));
    }
    
}