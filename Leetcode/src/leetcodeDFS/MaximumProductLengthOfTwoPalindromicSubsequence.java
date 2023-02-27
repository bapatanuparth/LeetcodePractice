package leetcodeDFS;

//Given a string s, find two disjoint palindromic subsequences of s such that the product of their lengths is maximized. The two subsequences are disjoint if they do not both pick a character at the same index.
//
//Return the maximum possible product of the lengths of the two palindromic subsequences.
//
//A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters. A string is palindromic if it reads the same forward and backward.

public class MaximumProductLengthOfTwoPalindromicSubsequence {

	int ans = 0;

	public int maxProduct(String s) {
		dfs(s.toCharArray(), 0, "", "");

		return ans;
	}

	// use dfs to calculate all possible palindromic subsequences
	// use two strings at a time, make sure when u take a character in 1 string,
	// dont take it in another string
	// compare 2 strings at a time
	void dfs(char[] c, int i, String s1, String s2) {
		if (i >= c.length) {
			if (isPal(s1) && isPal(s2)) {
				ans = Math.max(ans, s1.length() * s2.length());
			}
			return;
		}

		dfs(c, i + 1, s1 + c[i], s2);
		dfs(c, i + 1, s1, s2 + c[i]);
		dfs(c, i + 1, s1, s2);
	}

	boolean isPal(String s1) {

		int i = 0, j = s1.length() - 1;
		while (i <= j) {
			if (s1.charAt(i) != s1.charAt(j))
				return false;
			i++;
			j--;
		}

		return true;
	}

}
