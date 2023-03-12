package StringBuilder;

//Write a program that takes an input string and replaces all occurrences of a specified substring with a new substring.
// For example, if the input string is "Hello world" and the specified substring is "world", and the new substring is
// "Java", the output should be "Hello Java".


public class ReplaceSubstring {
    public static String replace(String input, String oldSubstring, String newSubstring) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < input.length()) {
            int start = input.indexOf(oldSubstring, index);
            if (start != -1) {
                sb.append(input, index, start);
                sb.append(newSubstring);
                index = start + oldSubstring.length();
            } else {
                sb.append(input, index, input.length());
                break;
            }
        }
        return sb.toString();
    }

}
