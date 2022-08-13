package leetCodeEasy;/*66. Plus One*/

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
//        int[] arr = new int[]{9, 9, 9};
//        int[] subarray = plusOne(arr);
//        for (int el: subarray){
//            System.out.println(el);
//        }

    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i]%10 != 0) {
                return digits;
            } else {
                digits[i] = 0;
            }

            if (i == 0) {
                digits = Arrays.copyOf(digits, digits.length + 1);
                digits[i] = 1;
            }
        }
        return digits;
    }
}
