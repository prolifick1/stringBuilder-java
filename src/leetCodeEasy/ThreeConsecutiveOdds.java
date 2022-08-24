package leetCodeEasy;
/*1313. Decompress Run-Length Encoded List*/

public class DecompressRunLengthEncodedList {
//    public static void main(String[] args) {
//        int[] arr = {1,2,1,2,1,2,1,1,2,1};
//        System.out.println(threeConsecutiveOdds(arr));
//    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                count++;
                if (count >= 3) {
                    return true;
                } else {
                    continue;
                }

            } else {
                count = 0;
            }
        }

        return false;
    }
}
