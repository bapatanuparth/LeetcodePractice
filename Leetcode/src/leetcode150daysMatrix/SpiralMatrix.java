package leetcode150daysMatrix;

import java.util.ArrayList;
import java.util.List;

//Given an m x n matrix, return all elements of the matrix in spiral order.

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] mat) {

		int m = mat.length;
		int n = mat[0].length;

		int maxUp = 0, maxRight = mat[0].length;
		int maxDown = mat.length, maxLeft = 0;
		List<Integer> ls = new ArrayList<>();

		while (maxUp <= maxDown && maxLeft <= maxRight) {

			for (int i = maxLeft; i < maxRight; i++) { // top horizontal
				ls.add(mat[maxUp][i]);
			}

			if (ls.size() == m * n)
				break;
			maxUp++;
			for (int i = maxUp; i < maxDown; i++) { // right vertical down
				ls.add(mat[i][maxRight - 1]);
			}
			if (ls.size() == m * n)
				break;

			maxRight--;

			for (int i = maxRight - 1; i >= maxLeft; i--) { // horizontal bottom reverse
				ls.add(mat[maxDown - 1][i]);
			}
			if (ls.size() == m * n)
				break;

			maxDown--;

			for (int i = maxDown - 1; i >= maxUp; i--) {
				ls.add(mat[i][maxLeft]);
			}
			if (ls.size() == m * n)
				break;

			maxLeft++;

		}

		return ls;
	}
}
