package leetCode.HashTables;


/*1365. How Many Numbers Are Smaller Than the Current Number*/
public class NumbersAreSmallerThanCurrentNumber {
//    public static void main(String[] args) {
//        int[] nums = {8, 6, 5, 4, 3};
//        System.out.println(smallerNumbersThanCurrent(nums));
//    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] temp = new int[101]; //from constraits

        for (int i = 0; i < n; i++) {
            temp[nums[i]]++;

        }

        for (int i = 1; i < 100; i++) {
            temp[i] += temp[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                ans[i] = 0;
            else
                ans[i] = temp[nums[i] - 1];
        }

        return ans;
    }
}