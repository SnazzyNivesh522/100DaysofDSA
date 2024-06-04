import java.util.PriorityQueue;

class Maximize_Happiness_of_Selected_Children {
       public long maximumHappinessSum(int[] happiness, int k) {
              PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
              for (int h : happiness) {
                     heap.add(h);
              }
              long maxHappiness = 0;
              int happiness_dec = 0;
              for (int i = 0; i < k; i++) {
                     maxHappiness += Math.max(heap.poll() - happiness_dec, 0);
                     happiness_dec++;
              }
              return maxHappiness;
       }
}