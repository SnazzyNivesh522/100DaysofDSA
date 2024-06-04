class Get_Equal_Substrings_Within_Budget {
       public int equalSubstring(String s, String t, int maxCost) {
              int n = s.length();
              int maxlen = 0;
              int left = 0;
              int cost = 0;
              for (int right = 0; right < n; right++) {
                     cost += Math.abs(s.charAt(right) - t.charAt(right));

                     while (cost > maxCost) {
                            cost -= Math.abs(s.charAt(left) - t.charAt(left));
                            left++;
                     }

                     maxlen = Math.max(maxlen, right - left + 1);
              }
              return maxlen;
       }
}