/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {
    private void reverse(int arr[],int start,int end){
        while (start < end) 
        { 
            int temp = arr[start]; 
            arr[start] = arr[end]; 
            arr[end] = temp; 
            start++; 
            end--; 
        } 

    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n; //if rotation exceeds length        
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-k-1);
        reverse(nums,0,n-1);
        
    }
    private void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        RotateArray obj=new RotateArray();
        int[] nums=new int[]{1,2,3,4,5,6,7};
        obj.rotate(nums, 3);
        obj.printArray(nums);

        nums=new int[]{-1,-100,3,99};
        obj.rotate(nums, 2);
        obj.printArray(nums);

        nums=new int[]{-1};
        obj.rotate(nums, 2);
        obj.printArray(nums);

        nums=new int[]{1,2};
        obj.rotate(nums, 3);
        obj.printArray(nums);

        nums=new int[]{1,2,3};
        obj.rotate(nums, 4);
        obj.printArray(nums);



    }
    
}
