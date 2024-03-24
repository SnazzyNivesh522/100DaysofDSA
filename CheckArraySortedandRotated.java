public class CheckArraySortedandRotated {
    public boolean check(int[] nums) {
        int pivot=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                pivot++;
            }            
        }        
        if(nums[nums.length-1]>nums[0]) {
            pivot++;
        }
        if(pivot<=1) return true;
        return false;
    }
    public static void main(String[] args) {
        CheckArraySortedandRotated c = new CheckArraySortedandRotated();
        System.out.println("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31:\n"+c.check(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31}));
        System.out.println("3,4,5,1,2 :"+c.check(new int[]{3,4,5,1,2}));
        System.out.println("2,1,3,4 :"+c.check(new int[]{2,1,3,4}));
        System.out.println("2,7,4,1,2,6,2 :"+c.check(new int[]{2,7,4,1,2,6,2}));
    }
    
}
