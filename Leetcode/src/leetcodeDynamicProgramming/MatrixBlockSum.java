package leetcodeDynamicProgramming;

public class MatrixBlockSum {

	// use the range sum query 2D problem logic
	private int[][] dp;

	// 1. write code to calculate sum of a rectangle inside matrix given 4
	// co-ordinates
	// 2. over the loop for each point, pass the valid rectangle co-ordinates to get
	// the sum till that point
	public void numMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		dp = new int[matrix.length + 1][matrix[0].length + 1]; // we take one more than the length we actually need
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	}

	public int[][] matrixBlockSum(int[][] mat, int k) {

		numMatrix(mat);

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				int row1 = i - k >= 0 ? i - k : 0;
				int col1 = j - k >= 0 ? j - k : 0;
				int row2 = i + k < mat.length ? i + k : mat.length - 1;
				int col2 = j + k < mat[0].length ? j + k : mat[0].length - 1;

				mat[i][j] = sumRegion(row1, col1, row2, col2);
			}
		}

		return mat;
	}
}
