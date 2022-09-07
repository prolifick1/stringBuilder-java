package YandexContest;
import java.io.InputStream;
import java.util.*;

public class TaskD {
    public static void main(String[] args) {
        String result = solve(System.in);
        System.out.println(result);
    }

    public static String solve(InputStream input) {
        Scanner scanner = new Scanner(input);
        int nRows = scanner.nextInt();
        int nCols = scanner.nextInt();
        scanner.nextLine();
        char[][] field = readField(scanner, nRows, nCols);
        Point exit = findExit(field, nRows, nCols);
        dfs(field, exit);
        return printField(field, nRows, nCols);
    }

    public static char[][] readField(Scanner scanner, int nRows, int nCols) {
        char[][] field = new char[nRows][nCols];
        for (int i = 0; i < nRows; i++) {
            String line = scanner.nextLine().trim();
            for (int j = 0; j < nCols; j++) {
                field[i][j] = line.charAt(j);
            }
        }
        return field;
    }

    private static String printField(char[][] field, int nRows, int nCols) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                sb.append(field[i][j]);
            }
            if (i + 1 < nRows) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    private static Point findExit(char[][] field, int nRows, int nCols) {
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (field[i][j] == 'S') {
                    return new Point(i, j, '\0');
                }
            }
        }
        throw new RuntimeException("It's impossible!");
    }

    private static ArrayList<Point> getNeighbors(char[][] field, int i, int j) {
        ArrayList<Point> neighbors = new ArrayList<>();
        Point[] candidates = new Point[]{
                new Point(i - 1, j, 'D'),
                new Point(i, j - 1, 'R'),
                new Point(i, j + 1, 'L'),
                new Point(i + 1, j, 'U'),
        };
        for (Point candidate : candidates) {
            char cellValue = field[candidate.row][candidate.col];
            if (cellValue == '#') {
                continue;
            }
            neighbors.add(candidate);
        }
        return neighbors;
    }

    private static void dfs(char[][] field, Point exit) {
        Stack<Point> toVisit = new Stack<>();
        HashSet<Point> visited = new HashSet<>();
        toVisit.add(exit);
        while (!toVisit.isEmpty()) {
            Point cell = toVisit.pop();
            visited.add(cell);
            if (cell.dir != '\0') {
                field[cell.row][cell.col] = cell.dir;
            }
            for (Point neighbor : getNeighbors(field, cell.row, cell.col)) {
                if (!visited.contains(neighbor)) {
                    toVisit.add(neighbor);
                }
            }
        }
    }

    private static class Point {
        public Point(int row, int col, char dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object obj) {
            Point other = (Point)obj;
            if (other != null) {
                return other.row == this.row && other.col == this.col;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        public int row ;
        public int col;
        public char dir;
    }
}
