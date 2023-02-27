package leetcodeDynamicProgramming;

//You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices given in the array mines. The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.
//
//Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.
//
//An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right, and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1's.
//

public class LargestPlusSign {

	public int orderOfLargestPlusSign(int n, int[][] mines) {
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = 1;
			}
		}

		for (int[] mine : mines) {
			grid[mine[0]][mine[1]] = 0;
		}

		boolean ones = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					ones = true;
					break;
				}
			}
		}
		if (ones == false)
			return 0;

		int[][] left = new int[n][n];
		int[][] right = new int[n][n];
		int[][] up = new int[n][n];
		int[][] down = new int[n][n];

		for (int i = 1; i < n - 1; i++) {

			for (int j = 1; j < n - 1; j++) {

				if (grid[i][j] == 0)
					continue;
				if (grid[i][j - 1] == 0)
					left[i][j] = 0;
				else {
					left[i][j] = left[i][j - 1] + 1;
				}
			}
		}

		for (int i = n - 2; i > 0; i--) {

			for (int j = n - 2; j > 0; j--) {

				if (grid[i][j] == 0)
					continue;
				if (grid[i][j + 1] == 0)
					right[i][j] = 0;
				else {
					right[i][j] = right[i][j + 1] + 1;
				}
			}
		}

		for (int i = 1; i < n - 1; i++) {

			for (int j = 1; j < n - 1; j++) {

				if (grid[i][j] == 0)
					continue;
				if (grid[i - 1][j] == 0)
					up[i][j] = 0;
				else {
					up[i][j] = up[i - 1][j] + 1;
				}
			}
		}

		for (int i = n - 2; i > 0; i--) {

			for (int j = n - 2; j > 0; j--) {

				if (grid[i][j] == 0)
					continue;
				if (grid[i + 1][j] == 0)
					down[i][j] = 0;
				else {
					down[i][j] = down[i + 1][j] + 1;
				}
			}
		}

		int largest = 0;
		for (int i = 1; i < n - 1; i++) {

			for (int j = 1; j < n - 1; j++) {

				largest = Math.max(largest,
						Math.min(left[i][j], Math.min(right[i][j], Math.min(up[i][j], down[i][j]))));
			}
		}
		return largest + 1;

	}
}
