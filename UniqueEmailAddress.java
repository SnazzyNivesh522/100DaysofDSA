/*
Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.

For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.

For example, "m.y+name@email.com" will be forwarded to "my@email.com".
It is possible to use both of these rules at the same time.

Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.

 

Example 1:

Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
Example 2:

Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
Output: 3
 */
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
