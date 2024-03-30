/*
You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].

For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).

Return an array answer where answer[i] is the answer to the ith query.

 

Example 1:

Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8] 
Explanation: 
The binary representation of the elements in the array are:
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
The XOR values for queries are:
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
Example 2:

Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
Output: [8,0,4,4]
 */

import java.util.Arrays;

public class XORsubqueriesofArray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int b[]=new int[arr.length];
        b[0]=arr[0];
        for(int i =1;i<arr.length;i++){
            b[i] = b[i-1]^arr[i];
        }
        int result[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            if(left==0){
                result[i]=b[right];
            }
            else{
                result[i]=b[right]^b[left-1];
            }
        }
        return result;
        
    }
    public static void main(String[] args) {
        XORsubqueriesofArray xa = new XORsubqueriesofArray();
        System.out.println(Arrays.toString(xa.xorQueries(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2},{0,3},{3,3}})));
        System.out.println(Arrays.toString(xa.xorQueries(new int[]{4,8,2,10}, new int[][]{{2,3},{1,3},{0,0},{0,3}})));
        System.out.println(Arrays.toString(xa.xorQueries(new int[]{2,3,4,7}, new int[][]{{2,2},{1,3}})));

    }
}
