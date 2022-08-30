package TinkoffTasks.Try;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TinkoffTryTask2 {

    static int lengthOfLake;
    static int countCountries;
    static Map<Integer, Integer> startPoints = new HashMap<>();

    static int shortestPath;

    public static void main(String[] args) throws FileNotFoundException {

        /* loading an input file and completion a map */
        input();

        searchingShortestPath();

        /*creating an output file*/
        output();

    }

    public static void input() throws FileNotFoundException {
        File textFile = new File("/Users/AllMightyPush/Desktop/secondTask.txt");
        Scanner sc = new Scanner(textFile);
        lengthOfLake = Integer.parseInt(sc.next());
        countCountries = Integer.parseInt(sc.next());
        sc.nextLine();
        shortestPath = lengthOfLake;

        int n = 1;
        while (sc.hasNext()) {
            startPoints.put(n, Integer.parseInt(sc.next()));
            n++;
        }
    }


    public static void output() {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new File("standardOutput.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.println(shortestPath);
        pw.close();
    }

    public static void searchingShortestPath() {

        for (Integer key : startPoints.keySet()) {
            int straightPath = 0;
            int reversPath = 0;

            if (key == 1) { /* first after zero point */
                straightPath = startPoints.get(countCountries) - startPoints.get(1);
            } else { /*from any points except the first */
                straightPath = lengthOfLake - startPoints.get(key) + startPoints.get(key - 1);
            }

            if (key == 1) { /* first after zero point */
                reversPath = lengthOfLake - startPoints.get(key + 1) + startPoints.get(key);
            } else if (key == countCountries) { /* last point */
                reversPath = startPoints.get(key) - startPoints.get(1);
            } else { /*from any points except the first and last */
                reversPath = startPoints.get(key) + lengthOfLake - startPoints.get(key + 1);
            }

            if (straightPath <= reversPath && straightPath < shortestPath) {
                shortestPath = straightPath;
            } else if (reversPath < shortestPath) {
                shortestPath = reversPath;
            }

        }
    }


}
