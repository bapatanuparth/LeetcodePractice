package leetcodeInterviewPrep;

//You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation
public class RotateImage {

	// a transpose of image followed by reversing each row can give the rotated
	// image
	public void rotate(int[][] matrix) {
		transpose(matrix);
		reverse(matrix);
	}

	void transpose(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n; i++) {

			for (int j = i + 1; j < n; j++) {
				int temp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}

	// reverse elements of each row
	void reverse(int matrix[][]) {
		int n = matrix.length;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;

			}
		}
	}
}
