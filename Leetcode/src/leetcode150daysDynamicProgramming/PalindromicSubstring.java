package leetcode150daysDynamicProgramming;

//Given a string s,return the number of palindromic substrings in it.
//
//A string is a palindrome when it reads the same backward as forward.
//
//A substring is a contiguous sequence of characters within the string.

public class PalindromicSubstring {

	public int countSubstrings(String s) {
		char[] str = s.toCharArray();
		int n = s.length();

		// odd length palindrome
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			int hi = i, low = i;
			while (low >= 0 && hi < str.length && str[low] == str[hi]) {
				hi++;
				low--;
				count++;
			}
		}

		for (int i = 0; i < str.length; i++) {
			int low = i, hi = i + 1;
			while (low >= 0 && hi < str.length && str[low] == str[hi]) {
				hi++;
				low--;
				count++;
			}
		}

		return count;
	}
}
