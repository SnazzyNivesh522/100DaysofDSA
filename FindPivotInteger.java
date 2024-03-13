import java.util.Scanner;

public class FindPivotInteger {
    public int pivotInteger(int n) {
        int left=1;
        int right=n;

        int sum=n*(n+1)/2;
        while(left<=right){
            int mid=(left+right)/2;
            //sum from 1->mid
            int sumMid=mid*(mid+1)/2;

            //sum from mid->n
            int sumNmid=sum-sumMid+mid;
            if(sumNmid==sumMid){
                return mid;
            }
            else if(sumNmid>sumMid){
                left=mid+1;
            }
            else{
                right=mid-1;
            }

        }
        return -1;
        
    }
    public static void main(String[] args) {
        FindPivotInteger fpi = new FindPivotInteger();
        System.out.println();
        System.out.println("Input number:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("The Pivot Integer is : " + fpi.pivotInteger(num));
        scanner.close();
    }
    
    
}
