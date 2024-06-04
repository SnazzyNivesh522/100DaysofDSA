import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Minimum_Cost_to_Hire_K_Workers {
       public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
              int n = quality.length;
              Double amount = Double.MAX_VALUE;
              PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
              double total_quality = 0;
              List<double[]> ratio_workers = new ArrayList<>();
              for (int i = 0; i < n; i++) {
                     double ratio = (double) wage[i] / quality[i];
                     ratio_workers.add(new double[] { ratio, quality[i] });
              }
              ratio_workers.sort((a, b) -> Double.compare(a[0], b[0]));
              for (double[] worker : ratio_workers) {
                     double ratio = worker[0];
                     total_quality += worker[1];
                     maxHeap.offer(worker[1]);
                     if (maxHeap.size() > k) {
                            total_quality -= maxHeap.poll();
                     }
                     if (maxHeap.size() == k) {
                            amount = Math.min(amount, total_quality * ratio);
                     }
              }
              return amount;

       }
}