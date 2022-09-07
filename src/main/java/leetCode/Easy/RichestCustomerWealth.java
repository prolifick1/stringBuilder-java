package leetCode.Easy;
/*1672. Richest Customer Wealth*/

import java.util.stream.IntStream;

public class RichestCustomerWealth {
//    public static void main(String[] args) {
//        int[][] arr = {{1, 2, 3}, {3, 2, 1}};
//        System.out.println(maximumWealth(arr));
//    }


    public static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<accounts.length; i++){
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++){
                sum+=accounts[i][j];
            }
            max = Math.max(sum,max);
        }
        return max;
    }

    public static int maximumWealth2(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< accounts.length; i++){
            max = Math.max(IntStream.of(accounts[i]).sum(), max);
        }
        return max;
    }

}
