package leetCode.Easy;
/*1394. Find Lucky Integer in an Array*/


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        System.out.println(findLucky(arr));
    }



    public static int findLucky2(int[] arr) {
        Arrays.sort(arr);
        int lucky = -1;
        int temp = arr[0];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (temp == arr[i]) {
                count++;
                if (i == arr.length - 1&&temp == count) {
                    lucky = Math.max(lucky,temp);
                }
            } else {
                if (temp == count) {
                    lucky = Math.max(lucky,temp);
                }
                temp = arr[i];
                count = 1;
            }
        }

        return lucky;
    }

    public static int findLucky(int[] arr) {  // one of implementations
        int lucky = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            map.merge(item, 1, Integer::sum);
        }

        for (Integer key : map.keySet()) {
            if (key == map.get(key)) {
                lucky = Math.max(lucky, key);
            }
        }
        return lucky;
    }
}
