package crackingCodeInterview.recursion;

import java.util.Arrays;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, 
 * or 3 steps at a time. Implement a method to count how many possible ways the child 
 * can run up the stairs.
 */
public class TripleStep {
    public static void main(String[] args) {
        System.out.println(countSteps(10));
    }

    static int countSteps(int n) {
        if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countSteps(n - 1) + countSteps(n - 2) + countSteps(n - 3);
		}
    }

    public static int countWays(int n) {
		int[] map = new int[n + 1];
		Arrays.fill(map, -1);
		return countWays(n, map);
	}
	
	public static int countWays(int n, int[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
			return memo[n];
		}
	}
}
