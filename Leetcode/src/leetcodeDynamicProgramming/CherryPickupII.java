package leetcodeDynamicProgramming;

public class CherryPickupII {

	Integer[][][] memo;

	public int cherryPickup(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		memo = new Integer[m + 1][n + 1][n + 1];
		return dfs(grid, m, n, 0, 0, n - 1);
	}

	int dfs(int[][] grid, int m, int n, int row, int colA, int colB) {
		if (colA < 0 || colB < 0 || colA >= n || colB >= n)
			return 0;

		if (row == m)
			return 0;

		if (memo[row][colA][colB] != null)
			return memo[row][colA][colB];

		int result = 0;
		result += grid[row][colA];
		result += grid[row][colB];

		int max = 0;
		for (int x = colA - 1; x <= colA + 1; x++) {
			for (int y = colB - 1; y <= colB + 1; y++) {
				if (x < y) { // make sure that these columns dont intersect for robA and robB
					max = Math.max(max, dfs(grid, m, n, row + 1, x, y));
				}
			}
		}

		result += max;

		return memo[row][colA][colB] = result;
	}

}
