public class MergeStringsAlternate {
    public String mergeAlternately(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        String word="";
        int i,j;
        i=j=0;
        while(i<m && j<n){
            
                word+=word1.charAt(i);                
                i++;            
            
                word+=word2.charAt(j);
                j++;
            
        }
        while(i<m){
            word+=word1.charAt(i);
            i++;
        }
        while(j<n){
            word+=word2.charAt(j);
            j++;
        }
        return word;

    }
    public static void main(String[] args) {
        MergeStringsAlternate ms = new MergeStringsAlternate();
        String word1="abc";
        String word2="pr";
        System.out.println(ms.mergeAlternately(word1, word2));
    }
    
}
