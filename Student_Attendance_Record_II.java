import java.util.Arrays;

class Student_Attendance_Record_II {
   private int MOD = 1000000007;

   private int memo[][][]; // [record length][absent days][consecutive late days]

   public int checkRecord(int n) {
      memo = new int[n + 1][2][3];
      // initializng memo with -1;
      for (int[][] arr : memo) {
         for (int m[] : arr) {
            Arrays.fill(m, -1);
         }
      }
      return totalCombinations(n, 0, 0);
   }

   private int totalCombinations(int n, int totalAbsent, int consecutiveLate) {
      if (totalAbsent >= 2 || consecutiveLate >= 3)
         return 0;

      if (n == 0)
         return 1;

      if (memo[n][totalAbsent][consecutiveLate] != -1) {
         return memo[n][totalAbsent][consecutiveLate];
      }

      int count = 0;
      count = totalCombinations(n - 1, totalAbsent, 0) % MOD; // PRESENT

      count = (count + totalCombinations(n - 1, totalAbsent + 1, 0)) % MOD; // ABSENT

      count = (count + totalCombinations(n - 1, totalAbsent, consecutiveLate + 1)) % MOD; // LATE

      memo[n][totalAbsent][consecutiveLate] = count;
      return count;
   }
}