package leetcodeDynamicProgramming;
//Given a string s and an integer k, return true if s is a k-palindrome.

//A string is k-palindrome if it can be transformed into a palindrome by removing at most k characters from it.

public class ValidPalindromeIII {

	// Try to find the longest palindromic subsequence.
	// check if longest palindromic subsequence length >= n-k as we can remove at
	// most k characters
	public boolean isValidPalindrome(String s, int k) {

		int n = s.length();
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();

		// reverse and apply logic of LCS
		int dp[][] = new int[s.length() + 1][s.length() + 1];

		for (int i = 1; i < dp.length; i++) {

			for (int j = 1; j < dp.length; j++) {

				if (s.charAt(i - 1) == sb.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// System.out.println(dp[n][n]);
		if (dp[n][n] >= n - k)
			return true;

		return false;
	}
}
