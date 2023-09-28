package leetcode150daysMatrix;

//Given an m x n matrix, return all elements of the matrix in spiral order.

public class Search2DMatrixII {

	public boolean searchMatrix(int[][] matrix, int target) {

		int row = matrix.length - 1;
		int col = 0;

		while (row >= 0 && col <= matrix[0].length - 1) {

			if (matrix[row][col] == target) {
				return true;
			}

			if (matrix[row][col] > target) {
				row--;
			} else {
				col++;
			}
		}

		return false;

	}

}
