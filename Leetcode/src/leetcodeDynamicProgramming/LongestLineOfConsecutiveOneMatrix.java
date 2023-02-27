package leetcodeDynamicProgramming;

//Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.
//
//The line could be horizontal, vertical, diagonal, or anti-diagonal.

public class LongestLineOfConsecutiveOneMatrix {
	public int longestLine(int[][] mat) {
		int dp[][][] = new int[mat.length][mat[0].length][4];
		int m = mat[0].length;
		// instead of creating 4 separate arrays, for each horizonatl, vertical ,
		// diagonal or anti-diagonal checks, create one 3D array for this
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (mat[i][j] == 0)
					continue;
				for (int k = 0; k < 4; k++)
					dp[i][j][k] = 1; // handles the case when i==0, or j==0 as well as any other element on board
										// that is 1

				if (j > 0)
					dp[i][j][0] += dp[i][j - 1][0]; // horizontal line
				if (i > 0 && j > 0)
					dp[i][j][1] += dp[i - 1][j - 1][1]; // diagonal
				if (i > 0)
					dp[i][j][2] += dp[i - 1][j][2]; // vertical
				if (j < m - 1 && i > 0)
					dp[i][j][3] += dp[i - 1][j + 1][3];

				max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
				max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
			}
		}

		return max;
	}

}
