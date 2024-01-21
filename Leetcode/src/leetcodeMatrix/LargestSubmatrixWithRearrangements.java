package leetcodeMatrix;

import java.util.Arrays;

//You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.
//
//Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.

public class LargestSubmatrixWithRearrangements {

//	For each column, find the number of consecutive ones ending at each position.

//	For each row, sort the cumulative ones in non-increasing order and "fit" the largest submatrix.

	public int largestSubmatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int ans = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] != 0 && i > 0) {
					matrix[i][j] += matrix[i - 1][j];
				}
			}

			int currRow[] = matrix[i].clone();

			Arrays.sort(currRow);
			for (int k = 0; k < n; k++) {
				ans = Math.max(ans, currRow[k] * (n - k));
			}
		}

		return ans;
	}

}
