class Reverse_Prefix_of_Word {
       public String reversePrefix(String word, char ch) {
              int n = word.length();
              int idx = 0;
              for (char w : word.toCharArray()) {
                     if (w == ch)
                            break;
                     idx++;
              }
              if (idx == 0 || idx == n)
                     return word;
              StringBuilder revWord = new StringBuilder();
              int i = 0;
              while (i <= idx) {
                     revWord.append(word.charAt(idx - i));
                     i++;
              }
              while (i < n) {
                     revWord.append(word.charAt(i));
                     i++;
              }

              return revWord.toString();
       }
}