class Relative_Ranks {
       public String[] findRelativeRanks(int[] score) {
              int n = score.length;
              PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
              for (int i = 0; i < n; i++) {
                     heap.add(new Pair<>(score[i], i));
              }
              String[] ranks = new String[n];
              int pos = 1;
              while (!heap.isEmpty()) {
                     Pair<Integer, Integer> curr = heap.poll();
                     int idx = curr.getValue();
                     if (pos == 1) {
                            ranks[idx] = "Gold Medal";
                     } else if (pos == 2) {
                            ranks[idx] = "Silver Medal";
                     } else if (pos == 3) {
                            ranks[idx] = "Bronze Medal";
                     } else {
                            ranks[idx] = String.valueOf(pos);
                     }
                     pos++;
              }
              return ranks;
       }
}