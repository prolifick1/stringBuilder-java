package leetCode.Easy;
/*1389. Create Target Array in the Given Order*/

public class CreateTargetArrayInGivenOrder {

    public  int[] createTargetArray(int[] nums, int[] index) {

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
