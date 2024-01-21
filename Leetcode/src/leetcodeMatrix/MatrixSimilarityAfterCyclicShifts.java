package leetcodeMatrix;

//You are given a 0-indexed m x n integer matrix mat and an integer k. You have to cyclically right shift odd indexed rows k times and cyclically left shift even indexed rows k times.
//
//Return true if the initial and final matrix are exactly the same and false otherwise.

public class MatrixSimilarityAfterCyclicShifts {
	class Solution {
		public boolean areSimilar(int[][] mat, int k) {
			int m = mat.length;
			int n = mat[0].length;
			int val = k % n;
			if (val == 0)
				return true;

			for (int i = 0; i < m; i++) {

				if (i % 2 == 0) {
					int a = n - val;
					for (int j = 0; j < n; j++) {
						if (mat[i][j] != mat[i][a % n])
							return false;
						a++;
					}
				} else {
					int a = val - 1;
					for (int j = n - 1; j >= 0; j--) {
						if (mat[i][j] != mat[i][a])
							return false;
						a--;
						if (a < 0)
							a = n - 1;
					}
				}

			}

			return true;
		}
	}

}
