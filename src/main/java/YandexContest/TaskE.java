package YandexContest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;


public class TaskE {
//    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println(solve());
//    }

    public static int solve() throws FileNotFoundException {

        String str = input();
        Map<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>() {{
            put('{', new ArrayList<Integer>());
            put('}', new ArrayList<Integer>());
        }};

        int res = -1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '}') {
                map.get(str.charAt(i)).add(i);
            }
        }

        if (Math.abs((map.get('{').size() - map.get('}').size())) > 1
                || ((map.get('{').size() - map.get('}').size()) == 0)) {
            return -1;
        }

        boolean x = map.get('{').size() > map.get('}').size();

        if (x) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '{') {
                    return i+1;
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '}') {
                    return i+1;
                }
            }
        }

        return res;
    }

    public static String input() throws FileNotFoundException {
        File textFile = new File("/Users/AllMightyPush/Desktop/input.txt");
        Scanner sc = new Scanner(textFile);
        String str = sc.nextLine();
        return str;
    }
//
//    public static void main(String[] args) {
//        File file = new File("input.txt");
//        try {
//            System.out.println(solve(new FileInputStream(file)));
//        } catch (Exception e) {
//            throw new RuntimeException("It's impossible");
//        }
//    }
//
//    public static int solve(InputStream stream) {
//        ArrayList<Bracket> brackets = readBrackets(stream);
//        int openCount = 0;
//        int closeCount = 0;
//        for (Bracket bracket : brackets) {
//            if (bracket.symbol == '{') {
//                ++openCount;
//            } else {
//                ++closeCount;
//            }
//        }
//
//        int absDiff = Math.abs(closeCount - openCount);
//        if (absDiff > 1 || absDiff == 0) {
//            return -1;
//        }
//
//        return openCount > closeCount ? solveForOpen(brackets) : solveForClose(brackets);
//    }
//
//    private static int solveForOpen(ArrayList<Bracket> brackets) {
//        Stack<Bracket> stack = new Stack<>();
//        for (Bracket bracket : brackets) {
//            if (bracket.symbol == '{') {
//                stack.push(bracket);
//                continue;
//            }
//
//            if (stack.isEmpty()) {
//                return -1;
//            }
//
//            stack.pop();
//        }
//
//        return stack.isEmpty() ? -1 : stack.pop().position;
//    }
//
//    private static int solveForClose(ArrayList<Bracket> brackets) {
//        Stack<Bracket> stack = new Stack<>();
//        boolean hasError = false;
//        int errorPosition = -1;
//        for (Bracket bracket : brackets) {
//            if (bracket.symbol == '{') {
//                stack.push(bracket);
//                continue;
//            }
//
//            if (stack.isEmpty()) {
//                if (hasError) {
//                    return -1;
//                }
//                hasError = true;
//                errorPosition = bracket.position;
//                continue;
//            }
//
//            stack.pop();
//        }
//
//        return errorPosition;
//    }
//
//    private static ArrayList<Bracket> readBrackets(InputStream stream) {
//        Scanner scanner = new Scanner(stream);
//        String expression = scanner.nextLine().trim();
//        ArrayList<Bracket> brackets = new ArrayList<>();
//        for (int i = 0; i < expression.length(); i++) {
//            char symbol = expression.charAt(i);
//            if (symbol == '{' || symbol  == '}') {
//                brackets.add(new Bracket(i + 1, symbol));
//            }
//        }
//        return brackets;
//    }
//
//    private static class Bracket {
//        int position;
//        char symbol;
//
//        Bracket(int position, char symbol) {
//            this.position = position;
//            this.symbol = symbol;
//        }
//    }
}
