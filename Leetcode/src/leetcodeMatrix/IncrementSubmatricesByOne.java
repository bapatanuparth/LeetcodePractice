package leetcodeMatrix;

//You are given a positive integer n, indicating that we initially have an n x n 0-indexed integer matrix mat filled with zeroes.
//
//You are also given a 2D integer array query. For each query[i] = [row1i, col1i, row2i, col2i], you should do the following operation:
//
//Add 1 to every element in the submatrix with the top left corner (row1i, col1i) and the bottom right corner (row2i, col2i). That is, add 1 to mat[x][y] for for all row1i <= x <= row2i and col1i <= y <= col2i.
//Return the matrix mat after performing every query.

public class IncrementSubmatricesByOne {
	public int[][] rangeAddQueries(int n, int[][] queries) {
		int mat[][] = new int[n][n];

		for (int[] q : queries) {
			int r1 = q[0];
			int c1 = q[1];
			int r2 = q[2];
			int c2 = q[3];

			for (int x1 = r1; x1 <= r2; x1++) {
				for (int y1 = c1; y1 <= c2; y1++) {
					mat[x1][y1] = mat[x1][y1] + 1;
				}
			}

		}

		return mat;
	}

}
