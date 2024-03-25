public class SumTwoIntegers {
    public int getSum(int a, int b) {
        while(b!=0){
            int temp=(a&b)<<1;
            a=a^b;
            b=temp;
        }
        return a;
    }
    public static void main(String[] args) {
        SumTwoIntegers s = new SumTwoIntegers();
        System.out.println("Sum of " + (-2) + " and "+ (-3)+" is "+s.getSum(-2,-3));
        System.out.println("Sum of " + (-1000) + " and "+ (1000)+" is "+s.getSum(-1000,1000));
    }
    
}
