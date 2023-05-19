package leetcodeDynamicProgramming;

//Given a string s. In one step you can insert any character at any index of the string.
//
//Return the minimum number of steps to make s palindrome.
//
//A Palindrome String is one that reads the same backward as well as forward.

public class MinInsertionStepsToMakeStringPalindrome {

//	As our task is to insert minimum number of additional characters to s to make it a palindrome, we would want to figure out the longest palindromic subsequence that we can make from the characters in s. Characters that cannot be included in the longest palindromic subsequence must be adjusted by adding additional characters at required indices to form the entire string palindrome.
//
//	The answer of the problem would be the length of s minus the length of the longest palindromic subsequence in s.

	int lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		int dp[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}

	public int minInsertions(String s) {
		int n = s.length();
		String rev = new StringBuilder(s).reverse().toString();

		return n - lcs(s, rev);
	}

}
