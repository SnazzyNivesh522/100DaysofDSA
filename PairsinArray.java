/**
 * PairsinArray
 */
public class PairsinArray {

    public static void  printPairs(int[] array){
        for(int i=0;i<array.length;i++){
            int curr=array[i];
            for(int j=i+1;j<array.length;j++){
                System.out.println("("+curr+","+array[j]+")");

            }
        }
    }
    public static void main(String[] args) {
        int  arr[] = new int[]{2,5,9,10,11,100};
        printPairs(arr);
    }
}