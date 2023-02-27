package leetcodeDynamicProgramming;

//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//
//Note: You can only move either down or right at any point in time.
public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		int dp[][] = new int[grid.length][grid[0].length]; // save minimum sum at that i, j in dp

		dp[0][0] = grid[0][0]; // starting point

		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {

				if (i == 0 && j == 0)
					continue;
				if (i == 0) { // for first row, check only previous element
					dp[i][j] = grid[i][j] + dp[i][j - 1];
				} else if (j == 0) // for first column check only top element
					dp[i][j] = grid[i][j] + dp[i - 1][j];
				else { // for inside elements take min of either top or left element
					dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[grid.length - 1][grid[0].length - 1];
	}
}
