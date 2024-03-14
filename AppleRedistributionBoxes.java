/*
You are given an array apple of size n and an array capacity of size m.

There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.

Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.

Note that, apples from the same pack can be distributed into different boxes.

Input: apple = [1,3,2], capacity = [4,3,1,5,2]
Output: 2
Explanation: We will use boxes with capacities 4 and 5.
It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.

Example 2:

Input: apple = [5,5,5], capacity = [2,4,2,7]
Output: 4
Explanation: We will need to use all the boxes.
 */

import java.util.Arrays;

public class AppleRedistributionBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        //total apples
        int total=0;
        for(int a:apple) total+=a;
        
         
        Arrays.sort(capacity);
        reverseSort(capacity);
        int currCapacity=0;
        int i;
        for(i=0;i<capacity.length;i++){

            currCapacity+=capacity[i];          
            if(currCapacity>=total) break;
            
        }
        return i+1;        
    }
    public void reverseSort(int []array){
        int len=array.length;
        for(int i=0;i<len/2;i++){
            int temp=array[i];
            array[i]=array[len-i-1];
            array[len-i-1]=temp;
        }
    }
    public static void main (String[]  args) {
	AppleRedistributionBoxes box = new AppleRedistributionBoxes();
        System.out.println("Number of boxes required : \napple=[1,3,2] \ncapacity=[4,3,1,5,2] \n" + box.minimumBoxes(new int[]{1,3,2}, new int[]{4,3,1,5,2}));
        
    
    }
}
