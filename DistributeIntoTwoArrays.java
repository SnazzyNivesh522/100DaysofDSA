public class DistributeIntoTwoArrays {
    public int[] resultArray(int[] nums) {

        int i,j;//i-arr1 j-arr2
        i=j=0;
        int arr1[]=new int[nums.length];
        int arr2[]=new int[nums.length];
        //dividing into two arrays
        arr1[0]=nums[0];
        arr2[0]=nums[1];
        for(int k=2;k<nums.length;k++){
            if(arr1[i]>arr2[j]){
                i++;
                arr1[i]=nums[k];
            }
            else{
                j++;
                arr2[j]=nums[k];
            }
        }
        //now merging them
        int merged[]=new int[nums.length];
        int z=0;
        for(int k=0;k<i+1;k++){
            merged[z]=arr1[k];
            z++;
        }
        for(int k=0;k<j+1;k++){
            merged[z]=arr2[k];
            z++;
        }
        return merged;
        
    }
    public static void main(String[] args) {
        DistributeIntoTwoArrays d = new DistributeIntoTwoArrays();
        int arr[]=new int[]{5,4,3,8};
        int result[]=d.resultArray(arr);
        System.out.println("The array after distributing is:");
        for(int i : result){
            System.out.print(i+" ");
        }
    }
    
}
