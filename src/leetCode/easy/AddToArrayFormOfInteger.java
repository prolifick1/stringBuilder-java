package leetCode.easy;
/*989. Add to Array-Form of Integer*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        int[] arr = {2,1,5};
        int k = 806;
        System.out.println(addToArrayForm(arr, k));

    }
        public static List<Integer> addToArrayForm(int[] array, int k) {
            List<Integer> ans = new ArrayList<>();

            int i = array.length;
            while (--i >= 0 || k > 0) {
                if (i >= 0)
                    k += array[i];
                ans.add(k % 10);
                k /= 10;
            }

            Collections.reverse(ans);
            return ans;
        }
}
