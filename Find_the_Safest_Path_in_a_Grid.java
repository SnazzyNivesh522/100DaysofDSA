import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Find_the_Safest_Path_in_a_Grid {
    private int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        Queue<int[]> queue = new LinkedList<>();
        int copy_grid[][] = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    queue.add(new int[] { r, c });
                } else {
                    copy_grid[r][c] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int curr[] = queue.poll();
            for (int d[] : dir) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];
                int safeness = copy_grid[curr[0]][curr[1]];
                if (r >= 0 && r < n && c >= 0 && c < n && copy_grid[r][c] == -1) {
                    copy_grid[r][c] = safeness + 1;
                    queue.add(new int[] { r, c });
                }
            }
        }

        // [i,j,safeness value]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        maxHeap.add(new int[] { 0, 0, copy_grid[0][0] });
        copy_grid[0][0] = -1;
        while (!maxHeap.isEmpty()) {
            int curr[] = maxHeap.poll();
            if (curr[0] == n - 1 && curr[1] == n - 1) {
                return curr[2];
            }

            for (int d[] : dir) {
                int r = curr[0] + d[0];
                int c = curr[1] + d[1];
                if (r >= 0 && r < n && c >= 0 && c < n && copy_grid[r][c] != -1) {
                    maxHeap.add(new int[] { r, c, Math.min(curr[2], copy_grid[r][c]) });
                    copy_grid[r][c] = -1;
                }
            }
        }
        return -1;
    }
}