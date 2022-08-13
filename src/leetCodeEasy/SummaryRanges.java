package leetCodeEasy;/*228. Summary Ranges*/

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    static int[] array = new int[]{0, 2, 3, 5, 6, 7};


//    public static void main(String[] args) {
//        System.out.println(summaryRanges(array).toString());
//    }

    public static List<String> summaryRanges(int[] array) {
        List<String> finalRanges = new ArrayList<>();
        int open = 0;
        int close = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] > array[i - 1] + 1) {
                open = array[i];
            }

            if (i == array.length - 1 || array[i] + 1 < array[i + 1]) {
                close = array[i];

                if (open == close) {
                    finalRanges.add( String.valueOf(open) );
                } else {
                    finalRanges.add(String.valueOf(open) + "->" + String.valueOf(close));
                }
            }
        }
        return finalRanges;
    }
}
