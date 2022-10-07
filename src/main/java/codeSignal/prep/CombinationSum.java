package codeSignal.prep;

import java.util.*;

/**
 * Given an array of integers a and an integer sum,
 * find all of the unique combinations in a that add up to sum.
 * The same number from a can be used an unlimited number of times in a
 * combination.
 * Elements in a combination (a1 a2 … ak) must be sorted in non-descending
 * order,
 * while the combinations themselves must be sorted in ascending order.
 * If there are no possible combinations that add up to sum, the output should
 * be the string "Empty".
 * 
 * Example
 * 
 * For a = [2, 3, 5, 9] and sum = 9, the output should be
 * solution(a, sum) = "(2 2 2 3)(2 2 5)(3 3 3)(9)".
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[] { 2, 3, 5, 9 }, 9));
    }

    static String solution(int[] a, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i1 : a)
            set.add(i1);
        int[] myArray = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(myArray);
        String ans = "";
        List<int[]> chosen = new ArrayList<>();
        ans = combinationSumHelper(myArray, sum, chosen, new StringBuilder(ans));
        if (ans.length() == 0)
            return "Empty";
        return ans;
    }

    static String combinationSumHelper(int[] a, int sum, List<int[]> chosen, StringBuilder ans) {
        if (sum == 0) {
            ans.append("(");
            for (int[] ints : chosen) {
                ans.append(ints[0] + " ");
            }
            ans.deleteCharAt(ans.length() - 1);
            ans.append(")");

        } else {
            for (int i = 0; i < a.length; i++) {
                if (chosen.size() == 0 || (sum - a[i] >= 0 && chosen.get(chosen.size() - 1)[1] <= i)) {
                    chosen.add(new int[] { a[i], i });
                    combinationSumHelper(a, sum - a[i], chosen, ans);
                    chosen.remove(chosen.size() - 1);// backtracking.
                }
            }
        }
        return ans.toString();
    }

}
