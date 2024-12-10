package leetcodeHash;

//You are given a 0-indexed string s, and a 2D array of integers queries, where queries[i] = [li, ri] indicates a substring of s starting from the index li and ending at the index ri (both inclusive), i.e. s[li..ri].
//
//Return an array ans where ans[i] is the number of same-end substrings of queries[i].
//
//A 0-indexed string t of length n is called same-end if it has the same character at both of its ends, i.e., t[0] == t[n - 1].
//
//A substring is a contiguous non-empty sequence of characters within a string.

public class NumberSameEndSubstrings {

	// we need to save number of times each character occurs before an index
	// so with this, in any substring we can easily check the number of times a
	// character occurs
	// based on this, we can calculate the substrings that start and end with same
	// character
	public int[] sameEndSubstringCount(String s, int[][] queries) {
		int dp[][] = new int[26][s.length() + 1]; // [26 x length]

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			for (int j = 0; j < 26; j++) {
				if ((ch - 'a') == j)
					dp[ch - 'a'][i + 1] = dp[ch - 'a'][i] + 1; // if the current char is equal, increase the frequency
																// count
				else
					dp[j][i + 1] = dp[j][i];// otherwise keep track of occurrences till now for each character
			}
		}

		int res[] = new int[queries.length];
		int k = 0;

		for (int[] q : queries) {
			int st = q[0];
			int end = q[1] + 1;
			int ans = end - st;
			// for each query, check for each character and its occurrence in the substring
			for (int i = 0; i < 26; i++) {
				if (dp[i][end] - dp[i][st] > 1) {
					int sub = dp[i][end] - dp[i][st]; // if a character occurs multiple times, then it adds to more
														// substrings, count them separately here
					int div = sub * (sub - 1) / 2;
					ans += div;
				}
			}
			res[k++] = ans;
		}

		return res;

	}

}
