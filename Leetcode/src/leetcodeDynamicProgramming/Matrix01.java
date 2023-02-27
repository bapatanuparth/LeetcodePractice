package leetcodeDynamicProgramming;
//Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

//
//The distance between two adjacent cells is 1.

public class Matrix01 {

	// can also be solved using BFS, first consider only all zero cells in queue,
	// and build BFS from that queue
	public int[][] updateMatrix(int[][] mat) {

		int m = mat.length, n = mat[0].length, INF = m + n; // infinite distance can be max == m+n

		// get min from top and left sides
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (mat[r][c] == 0)
					continue;
				int top = INF, left = INF;
				if (r - 1 >= 0)
					top = mat[r - 1][c];
				if (c - 1 >= 0)
					left = mat[r][c - 1];

				mat[r][c] = Math.min(top, left) + 1;
			}
		}

		// traverse from bottom and find min from bottom and right sides
		for (int r = m - 1; r >= 0; r--) {
			for (int c = n - 1; c >= 0; c--) {
				if (mat[r][c] == 0)
					continue;
				int bottom = INF, right = INF;
				if (r + 1 < m)
					bottom = mat[r + 1][c];
				if (c + 1 < n)
					right = mat[r][c + 1];

				mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
			}
		}

		return mat;

	}

}
