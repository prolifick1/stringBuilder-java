package hackerrank;

import java.util.ArrayList;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int swaps = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int k = i; k < arr.length; k++) {
                if(arr[i] > arr[k])  {
                    int temp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = temp;
                    swaps++;
                }
            }
        }
        System.out.printf("Number of swaps: %s\nFirst element: %s\nLast element: %s\n", swaps, arr[0], arr[arr.length - 1]);
    }
}
