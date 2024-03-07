public class GCDofString {
    public String gcdOfStrings(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        int gcd=euclidean_gcd(m,n);
        if(!(str1+str2).equals(str2+str1)){
            return " No Solution";
        }
        return str2.substring(0,gcd);
    }
    public int euclidean_gcd(int num1,int num2){
        //using gcd as taught in IS matlab
        if (num2==0){
            return num1;
        }
        else{
            return euclidean_gcd(num2,num1 % num2);
        }
    }
    public static void main(String[] args) {
        GCDofString gcs = new GCDofString();
        System.out.println("GCD of ABCABC and ABC is "+gcs.gcdOfStrings("ABCABC","ABC"));
        System.out.println("GCD of LEET and CODE is "+gcs.gcdOfStrings("LEET","CODE"));
    }
    
}
