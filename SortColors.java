public class SortColors {
    private void swap(int nums[],int x,int y){
        if(x==y) return;
        nums[x]=nums[x]+nums[y];
        nums[y]=nums[x]-nums[y];
        nums[x]=nums[x]-nums[y];
    }
    public void sortColors(int[] nums) {
        //red-0
        // white-1
        // blue-2
        int red=0;
        int white=0;
        int blue=nums.length-1;
        while(white<=blue){
            if(nums[white]==0){
                swap(nums,white,red);
                white++;
                red++;
            }
            else if(nums[white]==2){
                swap(nums,white,blue);
                
                blue--;
            }
            else{
                white++;
            }
        }        
    }
    public static void main(String[] args) {
        SortColors s=new SortColors();
        int[] nums=new int[]{2,0,2,1,1,0};
        s.sortColors(nums);
        for(int i:nums){ 
            System.out.print(i+" ");
        }
        System.out.println();
        nums=new int[]{2};
        s.sortColors(nums);
        for(int i:nums){ 
            System.out.print(i+" ");
        }
        System.out.println();
        nums=new int[]{2,0,1};
        s.sortColors(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }   
    }    
}
