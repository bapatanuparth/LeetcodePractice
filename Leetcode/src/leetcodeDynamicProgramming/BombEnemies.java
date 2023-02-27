package leetcodeDynamicProgramming;

public class BombEnemies {

	public int maxKilledEnemies(char[][] grid) {

		int rows = grid.length;
		int cols = grid[0].length;

		int[][] dp = new int[rows][cols];
		int max = 0;

		// traverse each row twice, from front and back
		int cnt = 0;
		for (int i = 0; i < rows; i++) {
			cnt = 0;
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '0') {
					dp[i][j] = cnt;
				} else if (grid[i][j] == 'E') {
					cnt++;
				} else {
					cnt = 0;
				}
			}

			cnt = 0;
			for (int j = cols - 1; j >= 0; j--) {
				if (grid[i][j] == '0') {
					dp[i][j] += cnt;
				} else if (grid[i][j] == 'E') {
					cnt++;
				} else {
					cnt = 0;
				}
			}
		}

		// traverse each column twice top and bottom
		cnt = 0;
		for (int i = 0; i < cols; i++) {

			cnt = 0;
			for (int j = 0; j < rows; j++) {
				if (grid[j][i] == '0') {
					dp[j][i] += cnt;
				} else if (grid[j][i] == 'E') {
					cnt++;
				} else {
					cnt = 0;
				}
			}

			cnt = 0;
			for (int j = rows - 1; j >= 0; j--) {
				if (grid[j][i] == '0') {
					dp[j][i] += cnt;
					max = Math.max(max, dp[j][i]);
				} else if (grid[j][i] == 'E') {
					cnt++;
				} else {
					cnt = 0;
				}
			}
		}

		return max;

	}
}
