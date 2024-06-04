import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Word_Break_II {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        List<String> sentences = new ArrayList<>();

        backtrack(0, s, wordSet, new StringBuilder(), sentences);
        return sentences;
    }

    private void backtrack(
            int start, String s, Set<String> wordSet,
            StringBuilder currsentence, List<String> sentences) {
        if (start == s.length()) {
            sentences.add(currsentence.toString().trim());
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                int currlen = currsentence.length();
                currsentence.append(word).append(" ");
                backtrack(end, s, wordSet, currsentence, sentences);
                currsentence.setLength(currlen);

            }
        }

    }
}