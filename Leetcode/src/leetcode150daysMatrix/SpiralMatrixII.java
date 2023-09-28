package leetcode150daysMatrix;

//Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
		if (n == 1) {
			return new int[][] { new int[] { 1 } };
		}
		int[][] mat = new int[n][n];
		int k = 1;
		int square = n * n;

		int maxtop = 0, maxbottom = n - 1, maxleft = 0, maxright = n - 1;

		while (k <= square) {
			for (int j = maxleft; j <= maxright; j++) {
				mat[maxtop][j] = k;
				k++;
			}
			maxtop++;
			if (k > square)
				break;
			for (int j = maxtop; j <= maxbottom; j++) {
				mat[j][maxright] = k;
				k++;
			}
			maxright--;
			if (k > square)
				break;
			for (int j = maxright; j >= maxleft; j--) {
				mat[maxbottom][j] = k;
				k++;
			}
			maxbottom--;
			if (k > square)
				break;
			for (int j = maxbottom; j >= maxtop; j--) {
				mat[j][maxleft] = k;
				k++;
			}
			maxleft++;
		}

		return mat;

	}

}
