package leetcodeDynamicProgramming;

//Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
//
//An interleaving of two strings s and t is a configuration where s and t are divided into n and m 
//substrings
// respectively, such that:
//
//s = s1 + s2 + ... + sn
//t = t1 + t2 + ... + tm
//|n - m| <= 1
//The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
//Note: a + b is the concatenation of strings a and b.

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();

		if (s3.length() != len1 + len2) {
			return false;
		}
		boolean[][] dp = new boolean[len1 + 1][len2 + 1];
		// stores whether string till this point is possible or not
		dp[0][0] = true;

		for (int i = 1; i <= len1; i++) {
			dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		}

		for (int j = 1; j <= len2; j++) {
			dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
		}

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				// if up and left both are same characters that match with target, we can keep
				// either of the 2
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = dp[i - 1][j];
				} else if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}

		return dp[len1][len2];
	}
}
