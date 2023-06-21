package leetcodeDynamicProgramming;

import java.util.Arrays;

public class MaxNumberMovesInGrid {

	public int maxMoves(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;
		int dp[][] = new int[grid.length][grid[0].length];

		// initialize dp
		for (int j = 0; j < grid.length; j++) {
			Arrays.fill(dp[j], -1);
		}
		// initialize base case
		for (int i = 0; i < m; i++)
			dp[i][0] = 0;

		int max = 0;
		for (int j = 1; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (dp[i][j - 1] != -1 && grid[i][j - 1] < grid[i][j])
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
				if (i != 0) {
					if (dp[i - 1][j - 1] != -1 && grid[i - 1][j - 1] < grid[i][j])
						dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
				if (i != m - 1) {
					if (dp[i + 1][j - 1] != -1 && grid[i + 1][j - 1] < grid[i][j])
						dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
				}
				max = Math.max(dp[i][j], max);
			}

		}

		return max;
	}

}
