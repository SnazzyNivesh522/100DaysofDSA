public class ReplaceQuestionMark {
    public String minimizeStringValue(String s) {
        int[] charCount = new int[26]; 
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                charCount[c - 'a']++; 
                result.append(c);
            } else {
                int minCount = Integer.MAX_VALUE;
                char minChar = ' ';
                for (int i = 0; i < 26; i++) {
                    if (charCount[i] < minCount) {
                        minCount = charCount[i];
                        minChar = (char) (i + 'a');
                    }
                }
                charCount[minChar - 'a']++; 
                result.append(minChar);
            }
        }

        return result.toString();
        
    }
    public static void main(String[] args) {
        ReplaceQuestionMark rqm=new ReplaceQuestionMark();
        System.out.println("Modified String for  ?abca? is "+rqm.minimizeStringValue("?abca?"));
        System.out.println("Modified String for  ??? is "+rqm.minimizeStringValue("???"));
        System.out.println("Modified String for  a?a? is "+rqm.minimizeStringValue("a?a?"));
        System.out.println("Modified String for  abcdefghijklmnopqrstuvwxy?? is "+rqm.minimizeStringValue("abcdefghijklmnopqrstuvwxy??"));

    }
    
}
