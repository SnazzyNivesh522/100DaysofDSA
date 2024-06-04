import java.util.Arrays;

class Special_Array_With_X_Elements_Greater_Than_or_Equal_X {
       public int specialArray(int[] nums) {
              int n = nums.length;
              Arrays.sort(nums);
              int right = 0;
              int ele_to_right = n;
              int left = -1;
              while (right < n) {
                     if ((nums[right] == ele_to_right) || (left < ele_to_right && ele_to_right < nums[right])) {
                            return ele_to_right;
                     }
                     while (right < n - 1 && nums[right] == nums[right + 1]) {
                            right++;
                     }
                     left = nums[right];
                     right++;
                     ele_to_right = n - right;
              }
              return -1;
       }
}