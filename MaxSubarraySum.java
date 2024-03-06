public class MaxSubarraySum {
    //brute force
    // public static void maxSubarrSum(int arr[]){
    //     int currsum=0;
    //     int maxSum=Integer.MIN_VALUE;
    //     for(int i=0;i<arr.length;i++){            
    //         for(int j=i;j<arr.length;j++){
    //             currsum=0;                
    //             for(int k=i;k<=j;k++){
    //                 currsum+=arr[k];                   
    //             }
    //             System.out.println(currsum);   
    //             if(maxSum<currsum){
    //                 maxSum=currsum;
    //             }                           
    //         }            
    //     }
    //     System.out.println("Max sum is :"+maxSum); 
    // }

    //Prefix Sum method
    public static void prefixSum(int arr[]){
        int prefix[]=new int[arr.length];
        //prefix[i-1]+arr[i]
        //prefix[end]-prefix[start-1]
        int currsum=0;
        int maxSum=Integer.MIN_VALUE;

        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        for(int i=0;i<arr.length;i++){
            int start=i;            
            for(int j=i;j<arr.length;j++){
                int end=j;
                currsum= start==0 ? prefix[end] : prefix[end]-prefix[start-1];               
                System.out.println(currsum);   
                if(maxSum<currsum){
                    maxSum=currsum;
                }                           
            }            
        }
        System.out.println("Max sum is :"+maxSum);

    }
    public static void main(String[] args) {
        int arr[] = { 1 , -2 , 6 , -1 , 3 };
        prefixSum(arr);
    }
}
