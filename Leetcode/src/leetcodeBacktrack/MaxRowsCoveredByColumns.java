package leetcodeBacktrack;

//You are given a 0-indexed m x n binary matrix matrix and an integer numSelect, which denotes the number of distinct columns you must select from matrix.
//
//Let us consider s = {c1, c2, ...., cnumSelect} as the set of columns selected by you. A row row is covered by s if:
//
//For each cell matrix[row][col] (0 <= col <= n - 1) where matrix[row][col] == 1, col is present in s or,
//No cell in row has a value of 1.
//You need to choose numSelect columns such that the number of rows that are covered is maximized.
//
//Return the maximum number of rows that can be covered by a set of numSelect columns.

public class MaxRowsCoveredByColumns {

	class Solution {
		int row[];
		int col[];
		int ans = 0;

		public int maximumRows(int[][] matrix, int numSelect) {
			int m = matrix.length;
			int n = matrix[0].length;
			row = new int[m];
			col = new int[n];

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] == 1) {
						row[i]++;
						col[j]++;
					}
				}
			}

			backtrack(matrix, numSelect, 0, 0);
			return ans;

		}

		void backtrack(int[][] matrix, int numSelect, int k, int column) {

			if (k == numSelect) {
				ans = Math.max(ans, checkrows());
				return;
			}
			if (column == col.length)
				return;

			backtrack(matrix, numSelect, k, column + 1);

			chooseCol(matrix, column);
			backtrack(matrix, numSelect, k + 1, column + 1);
			removeCol(matrix, column);

		}

		int checkrows() {
			int count = 0;
			for (int i : row) {
				if (i == 0)
					count++;
			}
			return count;
		}

		void chooseCol(int[][] matrix, int column) {
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][column] == 1) {
					row[i]--;
				}
			}
		}

		void removeCol(int[][] matrix, int column) {
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[i][column] == 1) {
					row[i]++;
				}
			}
		}

	}

}
