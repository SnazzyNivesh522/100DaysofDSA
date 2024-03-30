/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
*/

 
public class TrappingRainWater {
    public int trap(int[] height) {
        int trapped=0;
        int n=height.length;
        int maxLeft[]=new int[n];
        maxLeft[0]=height[0];
        int maxRight[]=new int[n];
        maxRight[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            maxLeft[i]=Math.max(maxLeft[i-1],height[i]);            
        }
        for(int i=n-2;i>=0;i--){
            maxRight[i]=Math.max(maxRight[i+1],height[i]);   

        }

        for(int i=1;i<n-1;i++){
            trapped+=Math.min(maxLeft[i],maxRight[i])-height[i];
        }
        return trapped;
    }
    public static void main(String[] args) {
        TrappingRainWater h=new TrappingRainWater();
        System.out.println(h.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(h.trap(new int[]{4,2,0,3,2,5}));
        
    }
    
}
