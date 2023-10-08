package leetcode150daysDynamicProgramming;

//Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int max = 0;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 || j == n - 1)
					dp[i][j] = matrix[i][j] - '0';
				else {
					if (matrix[i][j] == '1')
						dp[i][j] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
				}
				max = Math.max(max, dp[i][j]);
			}
		}

		return max * max;
	}
}
