package leetcodeDynamicProgramming;

import java.util.Arrays;

//You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 directions.
//
//Return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell. Since the answer may be very large, return it modulo 109 + 7.
//
//Two paths are considered different if they do not have exactly the same sequence of visited cells.

public class NumbertOfIncreasingPathsInGrid {
	// use straightforward dfs + memoization

	int MOD = 1000000007;

	public int countPaths(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < dp.length; i++)
			Arrays.fill(dp[i], -1);

		int ans = 0;
		// for each element, we calculate the number of possible paths starting from
		// that point
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				ans = (ans + dfs(grid, i, j, dp, visited, -1)) % MOD;
			}
		}

		return ans;
	}

	int dfs(int[][] grid, int i, int j, int[][] dp, boolean visited[][], int val) {
		// check all the possible paths from current point with respect to the previous
		// point
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] <= val)
			return 0;
		// if we already know paths from this element
		if (dp[i][j] != -1)
			return dp[i][j];

		int ans = 1;
		visited[i][j] = true;
		ans = (ans + dfs(grid, i - 1, j, dp, visited, grid[i][j])) % MOD;
		ans = (ans + dfs(grid, i, j - 1, dp, visited, grid[i][j])) % MOD;
		ans = (ans + dfs(grid, i + 1, j, dp, visited, grid[i][j])) % MOD;
		ans = (ans + dfs(grid, i, j + 1, dp, visited, grid[i][j])) % MOD;
		visited[i][j] = false;
		dp[i][j] = ans;
		return ans;
	}
}
