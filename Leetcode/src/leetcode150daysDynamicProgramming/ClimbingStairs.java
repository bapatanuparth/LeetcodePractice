package leetcode150daysDynamicProgramming;

//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class ClimbingStairs {

	public int climbStairs(int n) {

		int[] memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = 1;

		for (int i = 2; i < memo.length; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}

		return memo[n];

	}

	int memoize(int n, int[] memo) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		if (memo[n] != 0)
			return memo[n];

		memo[n] = memoize(n - 1, memo) + memoize(n - 2, memo);
		return memo[n];
	}

}
