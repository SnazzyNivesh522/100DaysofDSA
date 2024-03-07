public class MedianSortArr {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //using the logic of merging in merge sort
        int m=nums1.length;
        int n=nums2.length;
        int i=0,j=0,k=0;
        int num[]=new int[m+n];
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                num[k]=nums1[i];
                i++;k++;
            }
            else{
                num[k]=nums2[j];
                j++;k++;
            }
        }
        while(i<m){
            num[k]=nums1[i];
            i++;k++;
        }
        while(j<n){
            num[k]=nums2[j];
            j++;k++;
        }
        //odd length direct median
        if((m+n)%2==1){
            return num[(m+n)/2];
        }
        else{
            return (num[(m+n)/2]+num[(m+n)/2-1])/2.0;
        }

        
    }
    public static void main(String[] args) {
        int arr1[]=new int[]{1,3,5};
        int arr2[]=new int[]{2,6,9};

        MedianSortArr ma = new MedianSortArr();
        System.out.println(ma.findMedianSortedArrays(arr1, arr2));
    }
    
}
