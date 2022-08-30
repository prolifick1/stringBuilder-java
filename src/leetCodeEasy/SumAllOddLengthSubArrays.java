package leetCodeEasy;
/*1588. Sum of All Odd Length SubArrays*/

public class SumAllOddLengthSubArrays {
//    public static void main(String[] args) {
//        int[] arr = {1, 4, 2, 5, 3};
//        System.out.println(sumOddLengthSubArrays(arr));
//
//    }

    public static int sumOddLengthSubArrays(int[] arr) {
        int k = 1;
        int sum = 0;
        while (k <= arr.length) {
            sum += counting(arr, k);
            k += 2;
        }

        return sum;
    }

    public static int counting(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i + k <= arr.length; i++) {
            int n = 0;
            if (i + n >= arr.length) {
                return sum;
            }
            while (n < k) {
                sum += arr[i + n];
                n++;
            }
        }

        return sum;
    }

}
