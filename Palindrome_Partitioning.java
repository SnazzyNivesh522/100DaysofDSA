import java.util.ArrayList;
import java.util.List;

class Palindrome_Partitioning {
   private boolean isPalindrome(String s, int low, int high) {
      while (low < high) {
         if (s.charAt(low++) != s.charAt(high--))
            return false;
      }
      return true;
   }

   private void dfs(int index, String s, List<String> part, List<List<String>> palindromic) {
      if (index >= s.length()) { // out of bound
         palindromic.add(new ArrayList<>(part));
         return;
      }
      for (int j = index; j < s.length(); j++) {
         if (isPalindrome(s, index, j)) {
            part.add(s.substring(index, j + 1));
            dfs(j + 1, s, part, palindromic);
            part.remove(part.size() - 1);
         }
      }
   }

   public List<List<String>> partition(String s) {
      List<String> partitions = new ArrayList<>();
      List<List<String>> palindromic = new ArrayList<>();
      dfs(0, s, partitions, palindromic);
      return palindromic;
   }
}