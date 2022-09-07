package leetCode.Easy;
/*1464. Maximum Product of Two Elements in an Array*/

import java.util.Arrays;

public class MaximumProductTwoElementsArray {
//    public static void main(String[] args) {
//
//    }

    public int maxProduct2(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

}
