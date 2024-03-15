import java.util.Arrays;

/**
 * ProductArrayExceptSelf
 */
public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length];
        Arrays.fill(result,1);
        int leftptr=1;
        int rightptr=1;
        int j=nums.length-1;
        for(int i=0;i<nums.length-1;i++){
            leftptr*=nums[i];
            result[i+1]*=leftptr;

            rightptr*=nums[j];
            result[j-1]*=rightptr;
            j--;
        }
        return result;
        
    }
    public static void main(String[] args) {
        ProductArrayExceptSelf paes = new ProductArrayExceptSelf();
        System.out.println(Arrays.toString(paes.productExceptSelf(new int[]{1,2,3,4})));
    }
}