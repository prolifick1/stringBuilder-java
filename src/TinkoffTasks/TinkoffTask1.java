package TinkoffTasks;

import java.util.Arrays;
import java.util.Scanner;

public class TinkoffTask1 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Point bl1 = Point.read(scanner);
//        Point tr1 = Point.read(scanner);
//        Point bl2 = Point.read(scanner);
//        Point tr2 = Point.read(scanner);
//        System.out.println(solve(bl1, tr1, bl2, tr2));
//    }

    private static class Point {
        public int x;
        public int y;

        public static Point read(Scanner scanner) {
            Point result = new Point();
            result.x = scanner.nextInt();
            result.y = scanner.nextInt();
            return result;
        }
    }

    private static int max(int ... xs) {
        return Arrays.stream(xs).max().orElse(Integer.MIN_VALUE);
    }

    // bl == bottom left, tr == top right
    private static int solve(Point bl1, Point tr1, Point bl2, Point tr2) {
        int width = max(Math.abs(bl1.x - tr2.x), Math.abs(bl2.x - tr1.x), tr1.x - bl1.x, tr2.x - bl2.x);
        int height = max(Math.abs(bl1.y - tr2.y), Math.abs(bl2.y - tr1.y), tr1.y - bl1.y, tr2.y - bl2.y);
        int size = max(width, height);
        return size * size;
    }
}
