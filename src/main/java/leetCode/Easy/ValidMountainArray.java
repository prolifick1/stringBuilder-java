package leetCode.Easy;
/*941. Valid Mountain Array*/

public class ValidMountainArray {
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 1};
//        System.out.println(validMountainArray(arr));
//    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((count == 0 && arr[i] >= arr[i + 1]) || arr[i] == arr[i + 1]) {
                return false;
            } else if (arr[i] > arr[i + 1]) {
                return subCheck(arr, i);
            }
            if (arr[i + 1] > arr[i]) {
                count++;
            }
        }

        return false;
    }

    public static boolean subCheck(int[] arr, int k) {
        for (int i = k + 1; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


}
