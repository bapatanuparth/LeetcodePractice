package leetcodeInterviewPrep;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

	// without using extra space
	// flag first row and column whenerve any inside element is ==0
	// keep 2 booleans to see whether 1st column and row already contain a zero as
	// they will need to be made zeros if yes
	public void setZeroesEff(int[][] mat) {

		int m = mat.length;
		int n = mat[0].length;

		boolean firstCol = false;
		boolean firstRow = false;
		// check if first row and column need to be marked as zeros
		for (int i = 0; i < mat.length; i++) {
			if (mat[i][0] == 0) {
				firstCol = true;
				break;
			}
		}

		for (int i = 0; i < mat[0].length; i++) {
			if (mat[0][i] == 0) {
				firstRow = true;
				break;
			}
		}

		// flag the 1st row and column if inside element is zero
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					mat[i][0] = 0;
					mat[0][j] = 0;
				}
			}
		}

		// for inside elements if their wor's and col's first element is 0, make it zero
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (mat[i][0] == 0)
					mat[i][j] = 0;
				if (mat[0][j] == 0)
					mat[i][j] = 0;
			}
		}

		// if any of the row or col originally contained zeros, make the whole row|| col
		// ==0
		if (firstCol) {
			for (int i = 0; i < mat.length; i++) {
				mat[i][0] = 0;
			}
		}

		if (firstRow) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[0][j] = 0;
			}
		}

	}

	// easy solution, use sets to store rows and columns and then re iterate and
	// mark the rows and cols as zeros
	public void setZeroes(int[][] mat) {

		int m = mat.length;
		int n = mat[0].length;

		Set<Integer> row = new HashSet<>();
		Set<Integer> col = new HashSet<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (row.contains(i)) {
					mat[i][j] = 0;
				}
				if (col.contains(j)) {
					mat[i][j] = 0;
				}
			}
		}

	}
}
