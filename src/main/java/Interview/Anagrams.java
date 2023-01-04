package Interview;

import java.util.*;

public class Anagrams {

    public Map<String, List<String>> groupByAnagram(String str) {
        String[] arrWords = str.split(" ");
        Map<String, List<String>> map = new HashMap<>();

        for (String word : arrWords) {
            String sortedWord = sortLetters(word);
            map.computeIfAbsent(sortedWord, s -> new ArrayList<>()).add(word);
        }
        return map;
    }

    private String sortLetters(String str) {
        char[] arrChars = str.toCharArray();
        Arrays.sort(arrChars);

        return new String(arrChars);
    }
}
