package leetCodeEasy;

/*1748. Sum of Unique Elements*/
public class SumofUniqueElements {


//    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3, 2};
//        System.out.println(sumOfUnique(array));
//    }

    public static int sumOfUnique(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int prev = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (prev == nums[j]) {
                    nums[i] = 0;
                    nums[j] = 0;
                }
            }
            res = res + nums[i];
        }

        res = res + nums[nums.length - 1];

        return res;
    }
}
