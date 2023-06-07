package leetcodeDynamicProgramming;

import java.util.Arrays;

public class UncrossedLines {

	// Starting with the last (or first) number in both arrays is an intuitive way
	// to solve this problem.
	// If the last number of num1 equals the last number of num2, we will
	// undoubtedly draw a line between
	// these two numbers. This line will be included in the solution because it will
	// not intersect with any
	// other line drawn between the remaining numbers. The remaining numbers will
	// then be examined,
	// while the last number in both arrays will be ignored.

	// We can't draw a line between two arrays if their last numbers don't match.
	// We now have two options to explore: drop the last number of num1 while
	// keeping num2 as is, or
	// drop the last number of num2 while keeping num1 as is. We choose the option
	// in which we can draw more
	// lines.

	// iterative
	public int maxUncrossedLines(int[] nums1, int[] nums2) {
		int dp[][] = new int[nums1.length + 1][nums2.length + 1];
		// dp(i, j) shows the number of uncrossed lines till the points i in nums1 and j
		// in nums2

		for (int i = 1; i <= nums1.length; i++) {
			for (int j = 1; j <= nums2.length; j++) {
				if (nums1[i - 1] == nums2[j - 1]) // since these 2 values are same, a line can be drawn here, so we add
													// this to the previous possible lines without the current element
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else { // else, we keep max possible lines in previous seen combinations
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[nums1.length][nums2.length];
	}

	// recursive memoized solution
	class Solution {
		private int solve(int i, int j, int[] nums1, int[] nums2, int[][] memo) {
			if (i <= 0 || j <= 0) {
				return 0;
			}

			if (memo[i][j] != -1) {
				return memo[i][j];
			}

			if (nums1[i - 1] == nums2[j - 1]) {
				memo[i][j] = 1 + solve(i - 1, j - 1, nums1, nums2, memo);
			} else {
				memo[i][j] = Math.max(solve(i, j - 1, nums1, nums2, memo), solve(i - 1, j, nums1, nums2, memo));
			}
			return memo[i][j];
		}

		public int maxUncrossedLines(int[] nums1, int[] nums2) {
			int n1 = nums1.length;
			int n2 = nums2.length;

			int[][] memo = new int[n1 + 1][n2 + 1];
			for (int[] row : memo) {
				Arrays.fill(row, -1);
			}

			return solve(n1, n2, nums1, nums2, memo);
		}
	}
}
