package leetCode.Easy;
/*977. Squares of a Sorted Array*/

import java.util.Arrays;

public class SquaresOfASortedArray {
//    public static void main(String[] args) {
//    int[] arr = {-4,-1,0,3,10};
//        System.out.println(sortedSquares(arr));
//    }

    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

}
