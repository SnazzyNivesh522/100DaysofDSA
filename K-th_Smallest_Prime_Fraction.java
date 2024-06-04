import java.util.Comparator;
import java.util.PriorityQueue;

class Kth_Smallest_Prime_Fraction {

    private static class RatioComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] arr1, int[] arr2) {    

            double ratio1 = (double) arr1[0] / arr1[1];
            double ratio2 = (double) arr2[0] / arr2[1];
            if (ratio1 < ratio2) {
                return -1;
            } 
            else if (ratio1 > ratio2) {
                return 1;
            } 
            else {
                return 0;
            }
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new RatioComparator());
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                minHeap.offer(new int[] { arr[i], arr[j] });
            }
        }
        int kthfraction[] = new int[2];
        for (int i = 0; i < k; i++) {
            kthfraction = minHeap.poll();
        }
        return kthfraction;
    }
}