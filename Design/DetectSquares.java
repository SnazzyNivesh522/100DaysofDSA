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

