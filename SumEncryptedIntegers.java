/*
You are given an integer array nums containing positive integers. We define a function encrypt such that encrypt(x) replaces every digit in x with the largest digit in x. For example, encrypt(523) = 555 and encrypt(213) = 333.

Return the sum of encrypted elements.

 

Example 1:

Input: nums = [1,2,3]

Output: 6

Explanation: The encrypted elements are [1,2,3]. The sum of encrypted elements is 1 + 2 + 3 == 6.

Example 2:

Input: nums = [10,21,31]

Output: 66

Explanation: The encrypted elements are [11,22,33]. The sum of encrypted elements is 11 + 22 + 33 == 66.
 */
public class SumEncryptedIntegers {

    public int sumOfEncryptedInt(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            int max=0;
            int count=0;
            
            while(nums[i]>0)
            {
                int rem=nums[i]%10;
                max=Math.max(max,rem);
                nums[i]/=10;
                count++;
            }
            while(count>0){
                count--;
                nums[i]=nums[i]*10+max;
            }
            sum+=nums[i];
        }
        return sum;        
    }
    public static void main(String[] args) {
        SumEncryptedIntegers  sei = new SumEncryptedIntegers();
        System.out.println("Sum for 1,2,3 is:"+sei.sumOfEncryptedInt(new int[]{1,2,3}));
        System.out.println("Sum for 11,22,33 is:"+sei.sumOfEncryptedInt(new int[]{11,22,33}));
        System.out.println("Sum for 523,313 is:"+sei.sumOfEncryptedInt(new int[]{523,213}));
    }
    
}
