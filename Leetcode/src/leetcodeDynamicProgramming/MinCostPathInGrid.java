package leetcodeDynamicProgramming;

public class MinCostPathInGrid {

	public int minPathCost(int[][] grid, int[][] moveCost) {

		int dp[][] = new int[grid.length][grid[0].length];
		// in dp[i][j] we will store the min sum to reach that index i, j

		// forst row will be all zeros as nothing behind
		for (int i = 1; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {
				// for each column in next row, find out the minimum possible sum based on the
				// costs given to reach that index
				// for ex. we can reach 0th column from all the previous columns, so loop over
				// all previous columns and find the min possible sum required to reach the 0th
				// column of next row

				int min = Integer.MAX_VALUE;

				for (int k = 0; k < grid[0].length; k++) { // loop over previous columns
					int val = grid[i - 1][k]; // get the value of the element in previous row at kth column
					min = Math.min(min, dp[i - 1][k] + moveCost[val][j] + val); // moveCost[val][j] will have the value
																				// to move to jth column from i-1th row
					// also add val because the path consists of the sum of the values plus the
					// weights of the costs
				}
				dp[i][j] = min;

			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < grid[0].length; i++) {
			min = Math.min(min, dp[grid.length - 1][i] + grid[grid.length - 1][i]); // add the element values of the
																					// last row to get the right sum
		}

		return min;
	}
}
