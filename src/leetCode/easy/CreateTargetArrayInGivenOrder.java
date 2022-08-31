package leetCode.easy;
/*1389. Create Target Array in the Given Order*/

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArrayInGivenOrder {
//    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 3, 4};
//        int[] indexes = {0, 1, 2, 2, 1};
//        for (int item : createTargetArray(nums, indexes)) {
//            System.out.print(item + " ");
//        }
//    }

    public static int[] createTargetArray(int[] nums, int[] index) {

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (i == index[i]) {
                continue;
            } else if (i > index[i]) {

                for (int j = i; j > index[i]; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[index[i]] = val;

            } else {
                
                for (int j = index[i]; j < i; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[index[i]] = val;
            }

        }

        return nums;
    }
}
