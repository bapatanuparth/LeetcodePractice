package leetcodeDynamicProgramming;

//Given a gold mine called M of (n x m) dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. Initially the miner can start from any row in the first column. From a given cell, the miner can move

//
//to the cell diagonally up towards the right 
//to the right
//to the cell diagonally down towards the right
//Find out maximum amount of gold which he can collect.

public class GoldMines {
	static int maxGold(int n, int m, int M[][]) {
		// code here
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int dp[][] = new int[n + 1][m + 1];
			res = Math.max(backtrack(i, 0, M, dp), res);
		}
		return res;
	}

	// recursively call for all possible places to visit and then memoize the
	// solution
	static int backtrack(int i, int j, int M[][], int[][] dp) {
		if (i < 0 || j < 0 || i >= M.length || j >= M[0].length)
			return 0;

		if (dp[i][j] != 0)
			return dp[i][j];

		if (j == M[0].length)
			return M[i][j];

		int val1 = M[i][j] + backtrack(i - 1, j + 1, M, dp);
		int val2 = M[i][j] + backtrack(i, j + 1, M, dp);
		int val3 = M[i][j] + backtrack(i + 1, j + 1, M, dp);

		dp[i][j] = Math.max(val1, Math.max(val2, val3));
		return dp[i][j];
	}

}
