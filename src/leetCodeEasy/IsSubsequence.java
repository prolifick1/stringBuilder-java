package leetCodeEasy;
/*392. Is Subsequence*/

public class IsSubsequence {
    static int index = 0;
//    public static void main(String[] args) {
//        String str = "aaaaaaa";
//        String sub = "bbaa";
//        System.out.println(isSubsequence(str, sub));
//    }




    public static boolean isSubsequence(String str, String sub) {
        String[] splittedStr = str.split("");
        String newStr = "";
        int index = 0;


        if(sub.contains(str)){
            return true;
        }

        for (String el : splittedStr) {
            for (int i = index; i < sub.length(); i++) {
                if (sub.contains(el) && sub.lastIndexOf(el) >= index) {
                    newStr = newStr + el;
                    index = sub.indexOf(el, index) + 1;
                    break;
                }
            }
        }

        if (str.equals(newStr)) {
            return true;
        }
        return false;
    }

}
