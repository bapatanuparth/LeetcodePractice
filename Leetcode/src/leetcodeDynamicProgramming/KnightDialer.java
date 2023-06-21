package leetcodeDynamicProgramming;

import java.util.Arrays;

//The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L). The possible movements of chess knight are shown in this diagaram:
//
//A chess knight can move as indicated in the chess diagram below:

public class KnightDialer {

//we store all the possible places to move from each digit.
//	we apply basic dfs and memoize the solution
//	for memoization, 2 variables are n and i, i.e. for nth step moving from i location

	class Solution {
		int dialer[][];
		int dp[][];
		int MOD = 1000000007;

		public int knightDialer(int n) {
			// in a 2D array we store where a knight can go from each digit
			// we use dfs with memoization
			dialer = new int[][] { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 3, 9, 0 }, {}, { 1, 7, 0 }, { 2, 6 },
					{ 1, 3 }, { 2, 4 } };
			// we have 2 variables, n and i. we will store all the priously calculated ways
			// of moving a knight for n moves from position i so that it can be reused
			dp = new int[n + 1][10];
			int ans = 0;

			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], -1);
			}

			for (int i = 0; i <= 9; i++) {
				ans = (ans + (dfs(i, n - 1) % MOD)) % MOD; // carefully writing MOD for every addition
			}
			return ans;
		}

		int dfs(int i, int n) {
			if (dp[n][i] != -1)
				return dp[n][i];
			if (n == 0) {
				return 1;
			}
			int ans = 0;
			// from each positiopn, we move to next all possible locations
			for (int j = 0; j < dialer[i].length; j++) {
				ans = (ans + (dfs(dialer[i][j], n - 1) % MOD)) % MOD;
			}
			dp[n][i] = ans;
			return dp[n][i];
		}
	}

}
