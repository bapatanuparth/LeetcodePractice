package leetcodeDynamicProgramming;

public class UniquePathsII {

	// easy solution to tackle 0th row and column,
	class Solution1 {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			final int m = obstacleGrid.length;
			final int n = obstacleGrid[0].length;
			// dp[i][j] := unique paths from (0, 0) to (i - 1, j - 1)
			long[][] dp = new long[m + 1][n + 1];
			dp[0][1] = 1; // Can also set dp[1][0] = 1

			for (int i = 1; i <= m; ++i)
				for (int j = 1; j <= n; ++j)
					if (obstacleGrid[i - 1][j - 1] == 0)
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

			return (int) dp[m][n];
		}
	}

	class Solution {
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			if (obstacleGrid[0][0] == 1)
				return 0;

			int m = obstacleGrid.length;
			int n = obstacleGrid[0].length;
			int dp[][] = new int[m][n];

			// if obstactle found in any row, first column, mark all the rows below that as
			// 0
			for (int i = 0; i < m; i++) {
				if (obstacleGrid[i][0] != 1)
					dp[i][0] = 1;
				else {
					for (int j = i; j < m; j++)
						dp[j][0] = 0;
					break;
				}
			}

			// if obstacle found in any column, 1st row, mark all the columns after that as
			// 0
			for (int i = 0; i < n; i++) {
				if (obstacleGrid[0][i] != 1) {
					dp[0][i] = 1;
				} else {
					for (int j = i; j < n; j++)
						dp[0][j] = 0;
					break;
				}
			}

			// from 1 to end, calculate unique paths to reach a given point
			for (int i = 1; i < m; i++) {

				for (int j = 1; j < n; j++) {
					if (obstacleGrid[i][j] == 1) {
						dp[i][j] = 0;
						continue;
					}
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}

			return dp[m - 1][n - 1];
		}
	}
}
