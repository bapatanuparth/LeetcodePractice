package leetcodeDynamicProgramming;

import java.util.Arrays;

//Given an integer n, return the least number of perfect square numbers that sum to n.
//
//A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

public class PerfectSquares {

	public int numSquares(int n) {

		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		dp[1] = 1;
		// for each number we will store the min perfect sqaure terms that can form that
		// number
		for (int i = 2; i <= n; i++) {

			// from each number we one by one subtract all perfect squares starting from 1
			// i.e. suppose for i==3, we subtract 3 - 1^2 == 2
			// now dp[3] == 1 +dp[2] (1 because we subtracting 1 perfect square and reaching
			// to the
			// previous perfect square)
			// for i==4 we check for, min (dp[4] = dp[4 - 1^2] || dp[4 - 2^2])
			for (int j = 1; i - (j * j) >= 0; j++) {
				dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
			}
		}

		return dp[n];
	}
}
