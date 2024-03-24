public class DuplicationNumber {
    public int findDuplicate(int[] nums) {
        //step1:linked list cycle
        //step2:floyds tortoise and hare
        int slow=0;
        int fast=0;
        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast){
                break;
            }
        }
        int slow2=0;
        while(true){
            slow=nums[slow];
            slow2=nums[slow2];
            if(slow==slow2){
                return slow;
            }
        }
    }
    public static void main(String[] args) {
        DuplicationNumber dn=new DuplicationNumber();
        System.out.println("3,1,3,4,2 : "+dn.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println("1,3,4,2,2 : "+dn.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println("3,3,3,3,3 : "+dn.findDuplicate(new int[]{3,3,3,3,3}));
    }
    
}
