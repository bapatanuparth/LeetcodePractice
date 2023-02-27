package leetcodeDynamicProgramming;

import java.util.Collections;
import java.util.List;

//Given a triangle array, return the minimum path sum from top to bottom.
//
//For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

public class Triangle {

	class Solution {

		// in place
		public int minimumTotal(List<List<Integer>> triangle) {
			for (int row = 1; row < triangle.size(); row++) {
				for (int col = 0; col <= row; col++) {
					int smallestAbove = Integer.MAX_VALUE;
					if (col > 0) {
						smallestAbove = triangle.get(row - 1).get(col - 1);
					}
					if (col < row) {
						smallestAbove = Math.min(smallestAbove, triangle.get(row - 1).get(col));
					}
					int path = smallestAbove + triangle.get(row).get(col);
					triangle.get(row).set(col, path);
				}
			}
			return Collections.min(triangle.get(triangle.size() - 1));
		}
	}

	// my solution
	public int minimumTotal(List<List<Integer>> triangle) {
		// extra dp
		int dp[][] = new int[triangle.size()][triangle.size()];

		// fill with max value
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		// update 1st value
		dp[0][0] = triangle.get(0).get(0);

		// update all values from 1st column, could be done inside the other loop
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
		}

		int step = 2;
		for (int i = 1; i < triangle.size(); i++) {

			for (int j = 1; j < step; j++) {

				// each position can be reached from top or left top element
				if (dp[i - 1][j] != Integer.MAX_VALUE) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
				} else {
					// at the edge of stair, so only from left top
					dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
				}

			}
			step = step + 1;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; i++) {
			min = Math.min(min, dp[dp.length - 1][i]);
		}

		return min;
	}
}
