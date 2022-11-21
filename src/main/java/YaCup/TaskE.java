package YaCup;

import java.util.*;

public class TaskE {
    public class Main {
        public static boolean isFileInDirectory(String fileName, String dir) {
            return fileName.startsWith(dir);
        }

//        public static void main(String[] args) {
//            var scanner = new Scanner(System.in);
//            var dirsDelete = readInput(scanner);
//            var files = readInput(scanner);
//            var dirsToStatistic = readInput(scanner);
//
//            var statistic = countStatistic(dirsDelete, files, dirsToStatistic);
//            printStatistic(statistic);
//        }

        public static void printStatistic(Statistic statistic) {
            for (Map<String, Integer> st : statistic.getSt()) {
                System.out.println(st.size());

                for (Map.Entry<String, Integer> entry : st.entrySet()) {
                    System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
                }
            }
        }


        // in result statistic for every dir from dirsToStatistic: {file extension -> count of deleted files with this extension}
        public static Statistic countStatistic(List<String> dirsDelete, List<String> files, List<String> dirsToStatistic) {
            var stat = new Statistic(dirsToStatistic);
//        sortDirs(dirsDelete);
//        sortDirs(files);

            var cleanDirsToDelete = deleteIncludedDirs(dirsDelete);

            for (String fileName : files) {
                for (String dirToDelete : cleanDirsToDelete) {
                    if (isFileInDirectory(fileName, dirToDelete)) {
                        stat.take(fileName);
                    }
                }
            }
            return stat;
        }

        static List<String> deleteIncludedDirs(List<String> dirs) {
            var res = new ArrayList<String>(dirs.size());
            if (dirs.size() == 0) {
                return res;
            }

            sortDirs(dirs);

            var rootDir = dirs.get(0);
            res.add(rootDir);

            for (int i = 1; i < dirs.size(); i++) {
                // TODO: Rename method
                if (isFileInDirectory(dirs.get(i), rootDir)) {
                    continue;
                }
                res.add(dirs.get(i));
                rootDir = dirs.get(i);
            }

            return res;
        }

        static void sortDirs(List<String> dirs) {
            Collections.sort(dirs);
        }

        public static List<String> readInput(Scanner scanner) {
            var countStr = scanner.nextLine();
            int count = Integer.parseInt(countStr);

            var res = new ArrayList<String>(count);
            for (int i = 0; i < count; i++) {
                var word = scanner.nextLine();
                res.add(word);
            }
            return res;
        }
    }


}

class Statistic {
    private final List<String> dirsToStatistic;
    private final ArrayList<Map<String, Integer>> st;

    public Statistic(List<String> dirsToStatistic) {
        this.dirsToStatistic = dirsToStatistic;
        this.st = new ArrayList<>(dirsToStatistic.size());

        // init st
        for (int i = 0; i < dirsToStatistic.size(); i++) {
            st.add(i, new HashMap<>());
        }
    }

    // fileName MUST contain .
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public void take(String fileName) {
        for (int i = dirsToStatistic.size() - 1; i >= 0; i--) {
            if (!TaskE.Main.isFileInDirectory(fileName, dirsToStatistic.get(i))) {
                continue;
            }

            var ext = getExtension(fileName);
            st.get(i).merge(ext, 1, Integer::sum);
        }
    }

    public ArrayList<Map<String, Integer>> getSt() {
        return st;
    }
}