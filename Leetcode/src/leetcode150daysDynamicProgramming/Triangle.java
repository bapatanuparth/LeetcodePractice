package leetcode150daysDynamicProgramming;

import java.util.Arrays;
import java.util.List;

//Given a triangle array, return the minimum path sum from top to bottom.
//
//For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
		int dp[][] = new int[triangle.size()][triangle.size()];

		for (int i = 0; i < dp.length; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);

		dp[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j > 0) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
				}
				dp[i][j] += triangle.get(i).get(j);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int j = 0; j < dp.length; j++) {
			min = Math.min(min, dp[dp.length - 1][j]);
		}

		return min;
	}

}
