package leetCodeArrays2;

//An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

//
//Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

public class CheckIfRowColContainAllDigits {

	public boolean checkValid(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n; i++)
			if (!checkRow(matrix, i, n))
				return false;

		for (int i = 0; i < n; i++) {
			if (!checkCol(matrix, i, n))
				return false;
		}

		return true;
	}

	boolean checkRow(int[][] matrix, int row, int n) {

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {

			int val = matrix[row][i];
			if (arr[val - 1] > 0)
				return false;
			else
				arr[val - 1]++;
		}

		for (int val : arr)
			if (val == 0)
				return false;
		return true;
	}

	boolean checkCol(int[][] matrix, int col, int n) {

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {

			int val = matrix[i][col];
			if (arr[val - 1] > 0)
				return false;
			else
				arr[val - 1]++;
		}

		for (int val : arr)
			if (val == 0)
				return false;
		return true;
	}
}
