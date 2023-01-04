package leetCode.HashTables;

/*1512. Number of Good Pairs*/
public class NumberGoodPairs {
//    public static void main(String[] args) {
//        int[] arr = {1,1,1,1};
//    }

    public  int numIdenticalPairs(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    res++;
                }
            }
        }
        return res;
    }

}
