package leetCode.Easy;
/*1380. Lucky Numbers in a Matrix*/

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInMatrix {
//    public static void main(String[] args) {
//        int[][] matrix = {{56216}, {63251}, {75772}, {1945}, {27014}};
//
//        System.out.println(luckyNumbers(matrix));
//    }

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            int min = Integer.MAX_VALUE;
            int column = 0;
            for (int k = 0; k < matrix[r].length; k++) {
                if (matrix[r][k] < min) {
                    min = matrix[r][k];
                    column = k;
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                if(min<matrix[i][column]){
                    break;
                } else if(i==matrix.length-1){
                    list.add(min);
                }
            }
        }

        return list;
    }

}
