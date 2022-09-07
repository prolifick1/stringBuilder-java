package leetCode.Easy;
/*905. Sort Array By Parity*/


import java.util.ArrayList;

public class SortArrayByParity {

//    public static void main(String[] args) {
//        int [] array = {1,2,3,4,5,6,1,1,1,1,2,2,2,2,2,4,4,4,5,5,5,8};
//        array = sortArrayByParity(array);
//        for (int item: array){
//            System.out.println(item);
//        }
//
//
//    }

    public static int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                if (list.isEmpty()) {
                    list.add(nums[i]);
                } else {
                    list.add(list.size(), nums[i]);
                }
            } else {
                list.add(0, nums[i]);
            }
        }

        int[] arr = list.stream().mapToInt(i -> i).toArray();
        return arr;
    }

    public static int[] sortArrayByParity2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 == 0) {
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
