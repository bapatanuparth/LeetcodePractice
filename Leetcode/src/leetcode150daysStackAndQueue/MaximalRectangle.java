package leetcode150daysStackAndQueue;

import java.util.Stack;

//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

public class MaximalRectangle {

	public int maximalRectangle(char[][] matrix) {

		int largest = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] mat = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = matrix[i][j] - '0';
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || mat[i][j] == 0)
					continue;
				mat[i][j] = mat[i][j] + mat[i - 1][j];
			}

			Stack<int[]> st = new Stack<>();
			for (int j = 0; j < n; j++) {
				int temp[] = new int[] { Integer.MAX_VALUE, 0 };
				while (!st.isEmpty() && st.peek()[1] >= mat[i][j]) {
					temp = st.pop();
					largest = Math.max(largest, temp[1] * (j - temp[0]));
				}
				int index = Math.min(temp[0], j);
				st.push(new int[] { index, mat[i][j] });
			}
			while (!st.isEmpty()) {
				int temp[] = st.pop();
				largest = Math.max(largest, temp[1] * (n - temp[0]));
			}
		}

		return largest;
	}

}
