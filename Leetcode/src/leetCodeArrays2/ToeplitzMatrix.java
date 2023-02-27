package leetCodeArrays2;

//Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
//
//A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
public class ToeplitzMatrix {

	// check if element not equal to top left element return false
	public boolean isToeplitzMatrix(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;

		for (int i = m - 1; i >= 0; i--) {

			for (int j = n - 1; j >= 0; j--) {

				int val = matrix[i][j];

				if (i - 1 >= 0 && j - 1 >= 0) {

					if (matrix[i - 1][j - 1] != val)
						return false;
				}

			}
		}

		return true;
	}
}
