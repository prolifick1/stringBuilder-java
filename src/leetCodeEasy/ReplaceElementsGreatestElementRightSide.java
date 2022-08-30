package leetCodeEasy;
/*1299. Replace Elements with Greatest Element on Right Side*/

public class ReplaceElementsGreatestElementRightSide {


//    public static void main(String[] args) {
//        int[] array = {17, 18, 5, 4, 6, 1};
//        array = replaceElements(array);
//
//        for (int item : array) {
//            System.out.print(item);
//        }
//    }


    public static int[] replaceElements(int[] arr) {
        int i = arr.length - 1;
        int movingVal = arr[i];

        while (i >= 0) {
            if (arr[i] > movingVal) {
                int temp = arr[i];
                arr[i] = movingVal;
                movingVal = temp;
            } else {
                arr[i] = movingVal;
            }
            i--;
        }
        arr[arr.length-1] = -1;

        return arr;
    }
}
