/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/
package leetCode.HashTables;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] searchingSummands(int target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] indices = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                indices[1] = i;
                indices[0] = map.get(target - arr[i]);
                return indices;
            }
            map.put(arr[i], i);
        }

        return indices;
    }

}
