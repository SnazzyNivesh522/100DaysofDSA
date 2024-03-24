public class CapitalizetheTitle {
    public String capitalizeTitle(String title) {
        char []ct=title.toCharArray();
        int len=ct.length;
        for(int i=0;i<len;i++){
            int j=i;//first index of the word
            while(i<len && ct[i]!=' '){
                ct[i]=Character.toLowerCase(ct[i]);
                i++;
            }
            if(i-j>2){
                ct[j]=Character.toUpperCase(ct[j]);
            }
        }
        title=String.valueOf(ct);
        return title;
        
    }
    public static void main(String[] args) {
        CapitalizetheTitle c=new CapitalizetheTitle();
        System.out.println(c.capitalizeTitle("leetcode"));
        System.out.println(c.capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(c.capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(c.capitalizeTitle("i lOve leetcode"));
    }
    
}
