package leetCodeArrays2;

import java.util.Arrays;

//Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

public class MatrixRotation {

	public boolean findRotation(int[][] mat, int[][] target) {
		boolean check[] = new boolean[4];
		Arrays.fill(check, true);
		int n = mat.length;

		for (int i = 0; i < mat.length; i++) {

			for (int j = 0; j < target.length; j++) {

				if (mat[i][j] != target[i][j]) // for 0 degree rotation
					check[0] = false;
				if (mat[i][j] != target[n - j - 1][i]) // for 90 degree rotation
					check[1] = false;
				if (mat[i][j] != target[n - i - 1][n - j - 1]) // for 180 degree rotation
					check[2] = false;
				if (mat[i][j] != target[j][n - i - 1])// for 270 degree rotation
					check[3] = false;
			}
		}

		return check[0] || check[1] || check[2] || check[3];
	}
}
