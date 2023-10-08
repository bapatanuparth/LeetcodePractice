package leetcode150daysDynamicProgramming;

//Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
//
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.

public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String text1, String text2) {

		int n = text1.length();
		int m = text2.length();

		int dp[][] = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j <= m; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[n][m];
	}

}
