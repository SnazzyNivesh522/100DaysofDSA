import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesinArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList();
        for(int n:nums){
            n=Math.abs(n);
            if(nums[n-1]<0){
                result.add(n);
            }
            nums[n-1]=-nums[n-1];
            
        }
        return result;        
    }
    public static void main(String[] args) {
        FindDuplicatesinArray obj=new FindDuplicatesinArray();
        System.out.println(obj.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(obj.findDuplicates(new int[]{1,1}));
        System.out.println(obj.findDuplicates(new int[]{1}));
        System.out.println(obj.findDuplicates(new int[]{1,1,3,3,4,2,4,2}));
        System.out.println(obj.findDuplicates(new int[]{1,1,2}));
    }
}
