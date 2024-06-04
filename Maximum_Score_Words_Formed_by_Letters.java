class Maximum_Score_Words_Formed_by_Letters {
       private int[] freqLetter;
       private int maxScore;

       public int maxScoreWords(String[] words, char[] letters, int[] score) {
              freqLetter = new int[26];
              for (char c : letters) {
                     freqLetter[c - 'a']++;
              }
              maxScore = 0;
              maximize(0, words, score, new int[26], 0);
              return maxScore;
       }

       private void maximize(int w, String words[], int[] score, int[] freqInWord, int totalScore) {
              if (w == words.length) {
                     // update maxscore if current subset score is greater than earlier
                     maxScore = Math.max(maxScore, totalScore);
                     return;
              }

              maximize(w + 1, words, score, freqInWord, totalScore); // skipping words[w]

              for (char ch : words[w].toCharArray()) {
                     freqInWord[ch - 'a']++;
                     totalScore += score[ch - 'a'];
              }

              // take in subset if it is valid
              if (isValidWord(freqInWord)) {
                     maximize(w + 1, words, score, freqInWord, totalScore);
              }

              for (char ch : words[w].toCharArray()) {
                     freqInWord[ch - 'a']--;
                     totalScore -= score[ch - 'a'];
              }
       }

       private boolean isValidWord(int[] freqInWord) {
              for (int c = 0; c < 26; c++) {
                     if (freqLetter[c] < freqInWord[c]) {
                            return false;
                     }
              }
              return true;
       }
}