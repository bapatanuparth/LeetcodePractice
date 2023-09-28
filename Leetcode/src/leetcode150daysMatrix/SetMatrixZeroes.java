package leetcode150daysMatrix;

public class SetMatrixZeroes {

	public void setZeroes(int[][] mat) {

		int m = mat.length;
		int n = mat[0].length;

		boolean firstcol = false;
		boolean firstrow = false;

		// check if first row or column has zero or not
		for (int i = 0; i < n; i++) {
			if (mat[0][i] == 0) {
				firstrow = true;
				break;
			}
		}

		for (int i = 0; i < m; i++) {
			if (mat[i][0] == 0) {
				firstcol = true;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (mat[i][j] == 0) {
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (mat[i][0] == 0) {
					mat[i][j] = 0;
				}
				if (mat[0][j] == 0)
					mat[i][j] = 0;
			}
		}

		if (firstrow) {
			for (int i = 0; i < n; i++) {
				mat[0][i] = 0;
			}
		}
		if (firstcol) {
			for (int i = 0; i < m; i++) {
				mat[i][0] = 0;
			}
		}

	}

}
