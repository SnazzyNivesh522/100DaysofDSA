/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]
 

Constraints:

1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
All the elements of arr2 are distinct.
Each arr2[i] is in arr1.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> countMap=new HashMap<>();
        HashSet<Integer> arr2Set=new HashSet<>();
        List<Integer> notAppear=new ArrayList<>();
        for(int a:arr2){
            arr2Set.add(a);
        }
        for(int a:arr1){
            if(!arr2Set.contains(a)){
                notAppear.add(a);
            }
            countMap.put(a,countMap.getOrDefault(a,0)+1);            
        }
        Collections.sort(notAppear);
        int []result=new int[arr1.length];
        int i=0;
        for(int a:arr2){
            int freq=countMap.get(a);
            for(int j=0;j<freq;j++){
                result[i++]=a;
            }
        }
        for(int val:notAppear){
            result[i++]=val;
        }
        return result;
    }
    public static void main(String[] args) {
        int arr1[]=new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int arr2[]=new int[]{2,1,4,3,9,6};
        RelativeSortArray rs=new RelativeSortArray();
        int result[]=rs.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
        
        arr1=new int[]{28,6,22,8,44,17};
        arr2=new int[]{22,28,8,6};
        result=rs.relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}
