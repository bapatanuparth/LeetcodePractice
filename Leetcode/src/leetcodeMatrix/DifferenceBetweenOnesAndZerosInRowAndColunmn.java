package leetcodeMatrix;

//You are given a 0-indexed m x n binary matrix grid.
//
//A 0-indexed m x n difference matrix diff is created with the following procedure:
//
//Let the number of ones in the ith row be onesRowi.
//Let the number of ones in the jth column be onesColj.
//Let the number of zeros in the ith row be zerosRowi.
//Let the number of zeros in the jth column be zerosColj.
//diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
//Return the difference matrix diff.

public class DifferenceBetweenOnesAndZerosInRowAndColunmn {

	public int[][] onesMinusZeros(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[] oneRow = new int[m];
		int[] oneCol = new int[n];
		int[] zeroRow = new int[m];
		int[] zeroCol = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					oneRow[i]++;
					oneCol[j]++;
				} else {
					zeroRow[i]++;
					zeroCol[j]++;
				}
			}
		}

		int[][] diff = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				diff[i][j] = oneRow[i] + oneCol[j] - zeroRow[i] - zeroCol[j];
			}
		}

		return diff;
	}

}
