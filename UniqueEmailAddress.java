import java.util.HashSet;

public class UniqueEmailAddress {
     public int numUniqueEmails(String[] emails) {
        HashSet<String> unique=new HashSet<>();
        
        for(String e:emails){
            char[] email=e.toCharArray();
            int i=0;
            String localname="";
            //to get characters before + and @
            while (email[i]!='@'){
                if(email[i]=='+'){
                    break;
                }
                if(email[i]!='.'){
                    localname+=Character.toString(email[i]);
                }
                i++;
                
                           
            }
            //to skip characters after + and reach @
            while (email[i]!='@'){
                i++;
            }
            //to get domain name
            for(int j=i+1;j<email.length;j++){
                localname+=Character.toString(email[i]);
            }
            unique.add(localname);
            
        }
        return unique.size();
        
    }
    public static void main(String[] args) {
        UniqueEmailAddress  uea = new UniqueEmailAddress();
        System.out.println("Number of unique email address in \n "+"test.email+alex@leetcode.com   "+ "test.e.mail+bob.cathy@leetcode.com   "+ "testemail+david@lee.tcode.com");
        System.out.println(uea.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}
