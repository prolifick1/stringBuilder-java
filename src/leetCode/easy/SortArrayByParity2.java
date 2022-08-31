package leetCode.easy;


/*SortArrayByParity*/
public class SortArrayByParity2 {


//    public static void main(String[] args) {
//
//        int[] array = {1,4,4,3,0,3};
//        array = sortArrayByParity(array);
//        for (int item : array) {
//            System.out.println(item);
//        }
//    }

    public static int[] sortArrayByParity(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != nums[i] % 2) {

                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 != nums[i] % 2) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }

                }

            }
        }
        return nums;
    }

}
