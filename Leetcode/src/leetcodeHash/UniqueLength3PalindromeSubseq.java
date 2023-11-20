package leetcodeHash;

import java.util.Arrays;

//Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
//
//Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
//
//A palindrome is a string that reads the same forwards and backwards.
//
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
//For example, "ace" is a subsequence of "abcde".

public class UniqueLength3PalindromeSubseq {

	public int countPalindromicSubsequence(String s) {
		int first[] = new int[26], last[] = new int[26], res = 0;
		Arrays.fill(first, -1);
		Arrays.fill(last, -1);

		for (int i = 0; i < s.length(); i++) {
			if (first[s.charAt(i) - 'a'] == -1)
				first[s.charAt(i) - 'a'] = i;
			last[s.charAt(i) - 'a'] = i;
		}
		boolean[] visited;

		for (int i = 0; i < 26; i++) {
			int si = first[i];
			int ei = last[i];

			visited = new boolean[26];
			int count = 0;
			for (int j = si + 1; j < ei; j++) {
				if (visited[s.charAt(j) - 'a'] == false) {
					visited[s.charAt(j) - 'a'] = true;
					count++;
				}
			}
			res += count;
		}

		return res;
	}

}
