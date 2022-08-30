package leetCode.easy;
/*1217. Minimum Cost to Move Chips to The Same Position
*
* We have n chips, where the position of the ith chip is position[i].
We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.*/


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MinimumCostMoveChipsToTheSamePosition {
//    public static void main(String[] args) {
//        int[] arr = {6,4,7,8,2,10,2,7,9,7};
//        System.out.println(minCostToMoveChips(arr));
//    }

    public static int minCostToMoveChips(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.merge(arr[i], 1, Integer::sum);
        }

        int mostVal = Collections.max(map.values());
        int bestPos = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(mostVal)) {
                bestPos = entry.getKey();
            }
        }


        int countSteps = 0;
        for (Integer key : map.keySet()) {
            if (Math.abs(bestPos - key) % 2 != 0) {
                int n = map.get(key);
                while (n > 0) {
                    countSteps++;
                    n--;
                }

            }
        }

        return countSteps;
    }
}

