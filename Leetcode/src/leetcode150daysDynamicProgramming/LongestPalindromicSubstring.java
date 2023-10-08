package leetcode150daysDynamicProgramming;

//Given a string s, return the longest 
//palindromic
// 
//substring
// in s.

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {

		int n = s.length();
		char[] str = s.toCharArray();
		String res = "";
		int resLen = 0;

		// odd length palindrome
		for (int i = 0; i < n; i++) {

			int h = i, l = i;
			while (l >= 0 && h < n && str[h] == str[l]) {
				h++;
				l--;
			}

			int m = h - l - 1;
			if (m > resLen) {
				res = s.substring(l + 1, h);
				resLen = m;
			}

		}

		// even length palindrome
		for (int i = 0; i < n; i++) {

			int h = i + 1, l = i;
			while (l >= 0 && h < n && str[h] == str[l]) {
				h++;
				l--;
			}
			int m = h - l - 1;
			if (m > resLen) {
				res = s.substring(l + 1, h);
				resLen = m;
			}

		}

		return res;
	}
}
