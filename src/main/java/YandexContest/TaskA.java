package YandexContest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        System.out.println(comparison());
    }

    public static String comparison() {
        Map<Character, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                map.merge(a.charAt(i), 1, Integer::sum);
            }
        }

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (map.containsKey(b.charAt(i)) && map.get(b.charAt(i)) > 0) {
                    res.append('S');
                    map.merge(b.charAt(i), -1, Integer::sum);
                } else {
                    res.append('I');
                }
            } else {
                res.append('P');
            }

        }
        return res.toString();
    }
}
