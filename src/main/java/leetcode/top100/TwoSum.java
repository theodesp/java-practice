package leetcode.top100;

/**
 * Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, 
and you may not use the same element twice.

You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        var seen = new HashMap<Integer, Integer>();
        var result = new int[]{0, 0};
        for (var i = 0; i < nums.length; i++) {
            if (seen.containsKey(nums[i])) {
                result[0] = i;
                result[1] = seen.get(nums[i]);
            } else {
                seen.put(target-nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
