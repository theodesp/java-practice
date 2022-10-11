package codeSignal.prep;

import java.util.*;

/**
 * You have an array of integers nums and an array queries, where queries[i] is
 * a pair of indices
 * (0-based). Find the sum of the elements in nums from the indices at
 * queries[i][0] to queries[i][1]
 * (inclusive) for each query,
 * then add all of the sums for all the queries together. Return that number
 * modulo 109 + 7
 * 
 * For nums = [3, 0, -2, 6, -3, 2] and queries = [[0, 2], [2, 5], [0, 5]], the
 * output should be
 * solution(nums, queries) = 10.2
 * The array of results for queries is [1, 3, 6], so the answer is 1 + 3 + 6 =
 * 10.
 */
public class SumInRange {

    public static void main(String[] args) {
        System.out.println(solution2(new int[] { 3, 0, -2, 6, -3, 2 }, new int[][] {
                new int[] { 0, 2 }, new int[] { 2, 5 }, new int[] { 0, 5 }
        }));
    }

    static int solution(int[] nums, int[][] queries) {
        var sum = 0;
        int mod = 1000000007;
        for (var q : queries) {
            for (var i = q[0]; i <= q[1]; i += 1) {
                sum += nums[i];
            }
        }

        return (sum + mod) % mod;
    }

    static int solution2(int[] nums, int[][] queries) {
        long sol = 0L, mod =1000000007L, k=0L;
        var test = new ArrayList<Long>();
        for (int i = 0; i < nums.length; i++) {
            k += nums[i];
            test.add(k);
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                sol += test.get(queries[i][1]);
            } else {
                sol += test.get(queries[i][1]) - test.get(queries[i][0] - 1);
            }
        }
        return (int) Math.floorMod(sol, mod);
    }
}
