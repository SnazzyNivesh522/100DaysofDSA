/*
In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.

 

Example 1:


Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
Example 2:

Input: position = [5,4,3,2,1,1000000000], m = 2
Output: 999999999
Explanation: We can use baskets 1 and 1000000000.
 

Constraints:

n == position.length
2 <= n <= 105
1 <= position[i] <= 109
All integers in position are distinct.
2 <= m <= position.length

 */
import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = (position[n - 1] - position[0]) / (m - 1) + 1;
        int answer = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ballsPlaced(position, mid, m)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private boolean ballsPlaced(int[] position, int gap, int m) {
        int prevPosition = position[0];
        int balls = 1;
        for (int i = 1; i < position.length && balls < m; i++) {
            int currPosition = position[i];
            if (currPosition - prevPosition >= gap) {
                balls++;
                prevPosition = currPosition;
            }
        }
        return balls == m;
    }
    public static void main(String[] args) {
        MagneticForceBetweenTwoBalls solution = new MagneticForceBetweenTwoBalls();
        System.out.println(solution.maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(solution.maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
        System.out.println(solution.maxDistance(new int[]{1, 1000000000}, 2));
        System.out.println(solution.maxDistance(new int[]{1, 2, 3, 4, 5, 100}, 3));
    }
}
