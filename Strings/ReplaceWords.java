/*
In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
 

Constraints:

1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
sentence consists of only lower-case letters and spaces.
The number of words in sentence is in the range [1, 1000]
The length of each word in sentence is in the range [1, 1000]
Every two consecutive words in sentence will be separated by exactly one space.
sentence does not have leading or trailing spaces.

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        List<String> words = removeSpaces(sentence);
        List<String> replacedWords = new ArrayList<>();

        for (String word : words) {
            String replacement = word;
            for (String root : dictionary) {
                if (isDerivative(word, root) && root.length() < replacement.length()) {
                    replacement = root;
                }
            }
            replacedWords.add(replacement);
        }
        return replaceSentence(replacedWords);
    }
    private List<String> removeSpaces(String sentence) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ') {
                if (word.length() > 0) {
                    words.add(word.toString());
                    word = new StringBuilder();
                }
            } 
            else {
                word.append(c);
            }
        }
        if (word.length() > 0) {
            words.add(word.toString());
        }
        return words;
    }

    private boolean isDerivative(String word, String root) {
        if (word.length() < root.length()) {
            return false;
        }
        for (int i = 0; i < root.length(); i++) {
            if (word.charAt(i) != root.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private String replaceSentence(List<String> words) {
        StringBuilder sentence = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            if (i > 0) {
                sentence.append(' ');
            }
            sentence.append(words.get(i));
        }
        return sentence.toString();
    }
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new ReplaceWords().replaceWords(dictionary, sentence));

        dictionary=Arrays.asList("a","b","c");
        sentence="aadsfasf absbs bbab cadsfafs";
        System.out.println(new ReplaceWords().replaceWords(dictionary, sentence));
    }
}
