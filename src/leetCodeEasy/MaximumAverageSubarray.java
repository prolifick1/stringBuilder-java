package leetCodeEasy;
/*643. Maximum Average Subarray I*/

public class MaximumAverageSubarray {
//    public static void main(String[] args) {
//        int[] array = {-1};
//        int k = 1;
//        System.out.println(findMaxAverage(array, k));
//    }

    public static double findMaxAverage(int[] nums, int k) {
        double res = -Double.MAX_VALUE;
        int n = 0;
        int first = nums[0];
        long count = 0;

        if (k <= nums.length) {
            for (int i = 0; i < k; i++) {
                count += nums[i];
            }
            res = Math.max(res, (double) count/k);
        }

        for (int i = k; i < nums.length; i++) {
            count = count - first + nums[i];
            res = Math.max(res, (double)count/k);
            first = nums[i-k+1];
        }

        return res;
    }
}
