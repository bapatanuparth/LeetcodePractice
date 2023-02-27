package leetcodeDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		int dp[][] = new int[numRows][numRows];
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < numRows - (numRows - i) + 1; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
				temp.add(dp[i][j]);
			}

			res.add(temp);
		}
		return res;
	}

}
