package leetcode150daysDynamicProgramming;

import java.util.Arrays;

//You are given an array of words where each word consists of lowercase English letters.
//
//wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
//
//For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
//A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
//
//Return the length of the longest possible word chain with words chosen from the given list of words.

public class LongestStringChain {

	public int longestStrChain(String[] words) {
		Arrays.sort(words, (a, b) -> a.length() - b.length());

		int[] dp = new int[words.length];
		Arrays.fill(dp, 1);
		int ans = 1;

		for (int i = 1; i < words.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (checkWords(words[i], words[j])) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}

	boolean checkWords(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (s1.length() <= s2.length())
			return false;
		if (s1.length() - s2.length() > 1)
			return false;

		int diffCount = 0;
		int i = 0;
		int j = 0;

		while (i < len1 && j < len2) {
			if (s1.charAt(i) != s2.charAt(j)) {
				diffCount++;

				// If more than one difference found, return false
				if (diffCount > 1) {
					return false;

					// If the lengths are the same, move both pointers
				} else if (len1 == len2) {
					i++;
					j++;

					// If s1 is longer, only move the s1 pointer
				} else {
					i++;
				}
			} else {
				i++;
				j++;
			}
		}

		// If the lengths are different, s1 may have one extra character
		if (i < len1) {
			diffCount++;
		}

		// Check if s1 and s2 are one edit away
		return diffCount == 1;

	}
}
