package leetCode.easy;
/*1304. Find N Unique Integers Sum up to Zero*/

import java.util.Scanner;

public class FindNUniqueIntegersSumUpToZero {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        for (int item : sumZero(sc.nextInt())) {
//            System.out.print(item);
//        }
//    }

    public static int[] sumZero(int n) {
        int[] array = new int[n];
        int res = 0;

        if (array.length == 1) {
            array[0] = 0;
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                array[i] = i + 1;
                res += array[i];
            } else {
                array[i] = -res;
            }
        }
        return array;
    }
}
