/*
Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

 

Example 1:

Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: arr = [1,2,3]
Output: [1,2,3]
Explanation: After calling your function, the input array is modified to: [1,2,3]
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 9
 */

import java.util.Arrays;

public class DuplicateZerosInplace {
    public void duplicateZeros(int[] arr) {
        int zeros=0;
        int n=arr.length;
        int i=0,j=n-1;
        while(i<j){
            if(arr[i]==0){
                j--;
                zeros++;
            } 
            i++;
        }
        int k=i;
        // System.out.println("zeros:"+zeros+"i: "+i+"j: "+ j);
        for(i=n-1;i>=0 ;i--){
            if(j==k && arr[k]==0){
                arr[i]=arr[k];
                j--;
            }
            else if (arr[j]==0 && zeros>0){                
                arr[i]=arr[j];
                i--;
                arr[i]=arr[j];
                zeros--;
                j--;
            }
            else{
                arr[i]=arr[j];
                j--;
            }
        }
        // System.out.println("zeros:"+zeros+"i: "+i+"j: "+ j);
    }
    public static void main(String[] args) {
        int arr[]=new int[]{1,0,2,3,0,4,5,0};
        new DuplicateZerosInplace().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr=new int[]{1,2,3};
        new DuplicateZerosInplace().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr=new int[]{8,5,0,9,0,3,4,7};
        new DuplicateZerosInplace().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr=new int[]{8,4,5,0,0,0,0,7};
        new DuplicateZerosInplace().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr=new int[]{9,9,9,4,8,0,0,3,7,2,0,0,0,0,9,1,0,0,1,1,0,5,6,3,1,6,0,0,2,3,4,7,0,3,9,3,6,5,8,9,1,1,3,2,0,0,7,3,3,0,5,7,0,8,1,9,6,3,0,8,8,8,8,0,0,5,0,0,0,3,7,7,7,7,5,1,0,0,8,0,0};
        new DuplicateZerosInplace().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
        
        arr=new int[]{1,5,2,0,6,8,0,6,0};
        new DuplicateZerosInplace().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
