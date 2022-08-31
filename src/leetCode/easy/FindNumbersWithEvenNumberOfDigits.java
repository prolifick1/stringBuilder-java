package leetCode.easy;
/*1295. Find Numbers with Even Number of Digits*/

public class FindNumbersWithEvenNumberOfDigits {
//    public static void main(String[] args) {
//        int[] nums = {12, 2, 111, 33, 4444, 55555, 666666};
//        System.out.println(findNumbers(nums));
//    }

    public static int findNumbers(int[] nums) {
        int res = 0;
        int x = 0;
        for (int item : nums) {
            if (String.valueOf(item).length() % 2 == 0) {
                res++;
            }
        }

        return res;
    }
}
