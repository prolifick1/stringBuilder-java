package StringBuilder;

public class ReverseWords {
    public static String reverse(String input) {
        String[] words = input.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        reversed.deleteCharAt(reversed.length() - 1);
        return reversed.toString();
    }


}

