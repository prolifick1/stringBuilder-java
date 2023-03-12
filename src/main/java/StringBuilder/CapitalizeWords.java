package StringBuilder;

public class CapitalizeWords {
    public static String capitalize(String input) {
        String[] words = input.split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            String firstLetter = word.substring(0, 1);
            String restOfWord = word.substring(1);
            String capitalizedWord = firstLetter.toUpperCase() + restOfWord;
            capitalized.append(capitalizedWord).append(" ");
        }
        capitalized.deleteCharAt(capitalized.length() - 1);
        return capitalized.toString();
    }
}
