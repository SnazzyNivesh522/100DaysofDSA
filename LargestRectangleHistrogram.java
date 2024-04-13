/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 10^5
0 <= heights[i] <= 10^4
 */

import java.util.Stack;

public class LargestRectangleHistrogram {
    private static int[] nextSmaller(int arr[], int n) 
	{ 
	   int ans[]=new int[n];
	   Stack<Integer> stack=new Stack<>();
	   stack.push(-1);
	   for(int i=n-1;i>=0;i--){
	       int curr=arr[i];
	       while(stack.peek()!=-1 && arr[stack.peek()]>=curr){
	           stack.pop();
	       }
	       ans[i]=stack.peek();
	       stack.push(i);
	   }
	   return ans;
	}
    private static int[] prevSmaller(int arr[], int n) 
	{ 
	   int ans[]=new int[n];
	   Stack<Integer> stack=new Stack<>();
	   stack.push(-1);
	   for(int i=0;i<n;i++){
	       int curr=arr[i];
	       while(stack.peek()!=-1 && arr[stack.peek()]>=curr){
	           stack.pop();
	       }
	       ans[i]=stack.peek();
	       stack.push(i);
	   }
	   return ans;
	}
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        if(n==1) return heights[0];
        int next[]=nextSmaller(heights,n);
        int prev[]=prevSmaller(heights,n);
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int length=heights[i];
            
            if(next[i]==-1){
                next[i]=n;
            }
            int breadth=next[i]-prev[i]-1;

            int currArea=length*breadth;
            maxArea=Math.max(currArea,maxArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        LargestRectangleHistrogram obj=new LargestRectangleHistrogram();
        System.out.println(obj.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(obj.largestRectangleArea(new int[]{2,4}));
        System.out.println(obj.largestRectangleArea(new int[]{1}));
        System.out.println(obj.largestRectangleArea(new int[]{6,2,5,4,5,1,6}));
        System.out.println(obj.largestRectangleArea(new int[] {3, 5, 1, 7, 5, 9}));
        

    }
}
