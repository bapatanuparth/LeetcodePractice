package leetcodeDynamicProgramming;

import java.util.Arrays;

//You are given a string s and a character c. Return the total number of 
//substrings
// of s that start and end with c.
//
// 

public class CountSubstringStartingEndingWithGivenCharacter {

	public long countSubstrings(String s, char c) {
		int[] map = new int[26];
		Arrays.fill(map, -1);
		int count_char = 0;
		long dp[] = new long[s.length()];
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == c) {
				if (map[ch - 'a'] == -1) {
					map[ch - 'a'] = i;
				}
				dp[i] += dp[map[ch - 'a']] + count_char + 1;
				map[ch - 'a'] = i;
				count_char++;

			} else
				dp[i] = i > 0 ? dp[i - 1] : 0;
		}

		return dp[s.length() - 1];
	}
}
