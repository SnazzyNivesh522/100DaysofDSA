public class HappyNumber {
    public static boolean isHappy(int n) {
        //using same floyd tortoise and hare as in linked list cycle

        int slow=n,fast=n;
        do{
            slow=sumofSquares(slow);
            fast=sumofSquares(fast);
            fast=sumofSquares(fast);
        }while(slow!=fast);
        //above breaks when both becomes equal
        //if 1 we need then true else false
        if(slow==1)
            return true;
        return false;
        
    }
    public static int sumofSquares(int num){
        int sum=0,digit;
        do{
            digit=num%10;
            sum+=digit*digit;
            num/=10;
        }while(num>0);
        return sum;
    }
    public static void main(String[] args) {
        int number=19;
        if(isHappy(number))
            System.out.println(number+" is happy number ");
        else
            System.out.println(number+" is not happy number ");
        number=2;
        if(isHappy(number))
            System.out.println(number+" is happy number ");
        else
            System.out.println(number+" is not happy number ");
    }
}
