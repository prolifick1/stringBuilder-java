package leetCode.Easy;
/*1460. Make Two Arrays Equal by Reversing Sub-arrays*/

import java.util.Arrays;

public class MakeTwoArraysEqualReversingSub {
//    public static void main(String[] args) {
//        int[] target = {1, 2, 3, 4};
//        int[] arr = {1, 2, 3, 4};
//        System.out.println(canBeEqual(target, arr));
//    }


    public static boolean canBeEqual(int[] target, int[] arr) {
        if (target.length == 1 && arr[0] == target[0]) {
            return true;
        }

        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean canBeEqual2(int[] target, int[] arr) {
        int[] freq = new int[1000];
        int i = 0;
        while(i < target.length){
            freq[target[i] - 1]++;
            freq[arr[i] - 1]--;
            i++;
        }
        for(int val : freq){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}
