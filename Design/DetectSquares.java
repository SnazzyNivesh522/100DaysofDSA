/*
You are given a stream of points on the X-Y plane. Design an algorithm that:

Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
Given a query point, counts the number of ways to choose three points from the data structure such that the three points and the query point form an axis-aligned square with positive area.
An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.

Implement the DetectSquares class:

DetectSquares() Initializes the object with an empty data structure.
void add(int[] point) Adds a new point point = [x, y] to the data structure.
int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.
 

Example 1:


Input
["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
Output
[null, null, null, null, 1, 0, null, 2]

Explanation
DetectSquares detectSquares = new DetectSquares();
detectSquares.add([3, 10]);
detectSquares.add([11, 2]);
detectSquares.add([3, 2]);
detectSquares.count([11, 10]); // return 1. You can choose:
                               //   - The first, second, and third points
detectSquares.count([14, 8]);  // return 0. The query point cannot form a square with any points in the data structure.
detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
detectSquares.count([11, 10]); // return 2. You can choose:
                               //   - The first, second, and third points
                               //   - The first, third, and fourth points
 

Constraints:

point.length == 2
0 <= x, y <= 1000
At most 3000 calls in total will be made to add and count.
 */

import java.util.HashMap;


public class DetectSquares {
    private class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int getHash(Point P) {
        return P.x << 10 | P.y;
    }

    private HashMap<Integer, Integer> pointCount;

    public DetectSquares() {
        pointCount = new HashMap<>();
    }

    public void add(int[] point) {
        Point p = new Point(point[0], point[1]);

        pointCount.put(getHash(p), pointCount.getOrDefault(getHash(p), 0) + 1);
    }

    public int count(int[] point) {
        int squares = 0;
        int qx = point[0];
        int qy = point[1];
        for (int pHash : pointCount.keySet()) {
            int count = pointCount.get(pHash);
            int x = pHash >> 10;
            int y = pHash & 1023;
            if (Math.abs(qx - x) != Math.abs(qy - y) || x == qx || y == qy) { // cannot form a diagonal
                continue;
            }
            int newPoint1 = getHash(new Point(x, qy));
            int newPoint2 = getHash(new Point(qx, y));
            if (pointCount.containsKey(newPoint1) && pointCount.containsKey(newPoint2)) {
                squares += (count * pointCount.get(newPoint1) * pointCount.get(newPoint2));
            }
        }
        return squares;

    }
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{0, 1});
        detectSquares.add(new int[]{1, 0});
        detectSquares.add(new int[]{0, 0});
        System.out.println(detectSquares.count(new int[]{1,1}));
        System.out.println(detectSquares.count(new int[]{0,0}));
        System.out.println(detectSquares.count(new int[]{2,2}));

    }
}

