package TinkoffTasks.Try;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TinkoffTryTask1 {
    static Map<String, String> mapOfStrings = new HashMap();

//    public static void main(String[] args) throws FileNotFoundException {
//
//        /* input file and declaring map of Strings */
//        input();
//
//        /* here we check all Strings of Map and change values if it takes our requirements  */
//        bypassStrings();
//
//        /*creating of file for output... Task has no requirements about ignore lower and upper cases */
//        output();
//    }

    public static void input() throws FileNotFoundException {
        File textFile = new File("/Users/AllMightyPush/Desktop/names.txt");
        Scanner sc = new Scanner(textFile);
        int n = Integer.parseInt(sc.nextLine());
        while (n > 0) {
            mapOfStrings.put(sc.nextLine(), "No");
            n--;
        }
    }

    public static void bypassStrings() {
        for (String key : mapOfStrings.keySet()) {
            if (key.length() == 4) {
                if (mainCheck(key)) {
                    mapOfStrings.put(key, "Yes");
                }
            }
        }
    }

    public static boolean mainCheck(String line) {

        for (char item : line.toCharArray()) {
            int count = 0;
            for (int i = 0; i < line.length(); i++) {

                if (!Character.isLetter(item) || !Character.isLetter(line.charAt(i))){
                    return false;
                }

                if (item == line.charAt(i)) {
                    count++;
                    if (count > 2) {
                        return false;
                    }
                }
            }
            if (count < 2) {
                return false;
            }
        }
        return true;
    }

    public static void output() {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new File("standardOutput.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (String key : mapOfStrings.keySet()) {
            pw.println(key + " " + mapOfStrings.get(key));
        }
        pw.close();
    }

}

