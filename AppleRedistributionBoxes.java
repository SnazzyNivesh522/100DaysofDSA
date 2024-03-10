import java.util.Arrays;

public class AppleRedistributionBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        //total apples
        int total=0;
        for(int a:apple) total+=a;
        
         
        Arrays.sort(capacity);
        reverseSort(capacity);
        int currCapacity=0;
        int i;
        for(i=0;i<capacity.length;i++){

            currCapacity+=capacity[i];          
            if(currCapacity>=total) break;
            
        }
        return i+1;        
    }
    public void reverseSort(int []array){
        int len=array.length;
        for(int i=0;i<len/2;i++){
            int temp=array[i];
            array[i]=array[len-i-1];
            array[len-i-1]=temp;
        }
    }
    public static void main (String[]  args) {
	AppleRedistributionBoxes box = new AppleRedistributionBoxes();
        System.out.println("Number of boxes required : \napple=[1,3,2] \ncapacity=[4,3,1,5,2] \n" + box.minimumBoxes(new int[]{1,3,2}, new int[]{4,3,1,5,2}));
        
    
    }
}
