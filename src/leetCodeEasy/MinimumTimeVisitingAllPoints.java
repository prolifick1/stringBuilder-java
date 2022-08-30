package leetCodeEasy;
/*1266. Minimum Time Visiting All Points
*
* On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.

You can move according to these rules:

In 1 second, you can either:
move vertically by one unit,
move horizontally by one unit, or
move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
You have to visit the points in the same order as they appear in the array.
You are allowed to pass through points that appear later in the order, but these do not count as visits.*/

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int[][] points = {{1, 1}, {1, 2}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int[] currentPos = points[0];
        int res = 0;

        for (int i = 1; i < points.length; i++) {
            if (currentPos[0] == points[i][0] && currentPos[1] == points[i][1]) {
                currentPos = points[i];
                continue;
            }

            res += timeStep(currentPos, points[i]);
            currentPos = points[i];
        }
        return res;
    }

    public static int timeStep(int[] currentPos, int[] nextPos) {
        int res = 0;

        if (currentPos[0] == nextPos[0]) {
            while (currentPos[1] != nextPos[1]) {
                res += 1;
                if (currentPos[1] > nextPos[1]) {
                    currentPos[1]--;
                } else {
                    currentPos[1]++;
                }
            }
        } else if (currentPos[1] == nextPos[1]) {
            while (currentPos[0] != nextPos[0]) {
                res += 1;
                if (currentPos[0] > nextPos[0]) {
                    currentPos[0]--;
                } else {
                    currentPos[0]++;
                }
            }
        } else {

        }
        return res;
    }
}
