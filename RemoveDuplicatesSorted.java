public class RemoveDuplicatesSorted {
    public int removeDuplicates(int[] nums) {
        //two pointer approach
        //insertion sort kind of approach inserting elements
        int left=1;
        for(int right=1;right<nums.length;right++){
            if(nums[right]!=nums[right-1]){
                nums[left]=nums[right];
                left++;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        RemoveDuplicatesSorted rds = new RemoveDuplicatesSorted();
        int arr[]={0,0,1,1,1,2,3,3};
        System.out.println("Array before removing duplicates : ");
        for(int i:arr){
            System.out.print(i+"     ");
        }
        System.out.println("\nArray after removing duplicates : ");
        int k=rds.removeDuplicates(arr);
        int i=0;
        while(i<k)
        {
            System.out.print(arr[i]+"   "); 
            i++;
        }


    }
    
}
