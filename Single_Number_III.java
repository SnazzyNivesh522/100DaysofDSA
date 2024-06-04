class Single_Number_III {
       public int[] singleNumber(int[] nums) {
              if (nums.length == 2)
                     return nums;
              int xor = 0;
              for (int num : nums) {
                     xor ^= num;
              }
              int diff_bit = 1;
              while ((xor & diff_bit) == 0) {
                     diff_bit = diff_bit << 1;
              }
              int a = 0, b = 0; // groups where bit is set and not set
              for (int num : nums) {
                     if ((diff_bit & num) != 0) {
                            a ^= num;
                     } else {
                            b ^= num;
                     }
              }
              return new int[] { a, b };
       }
}