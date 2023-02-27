package leetcodeDynamicProgramming;

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
		// sort in ascending order of lengths so that we can run dp on it
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		// System.out.println(Arrays.toString(words));

		// create a dp array
		// at ith location we store the max possible chain till that point
		int dp[] = new int[words.length];
		Arrays.fill(dp, 1);
		int answer = 1;

		for (int i = 0; i < words.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (check(words[i], words[j])) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			answer = Math.max(answer, dp[i]);
		}
		return answer;
	}

	// check to know if the word c is predecessor for word or not
	// check by removing 1 character at a time from word to see if it matches with c
	boolean check(String word, String c) {
		if (word.length() == c.length() + 1) {
			StringBuilder sb = new StringBuilder(word);

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				sb.deleteCharAt(i);
				if (sb.toString().equals(c))
					return true;
				sb.insert(i, ch);
			}
		}
		return false;
	}
}
