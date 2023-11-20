package leetcodeStrings;

//Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
//
//A string is homogenous if all the characters of the string are the same.
//
//A substring is a contiguous sequence of characters within a string.

public class CountNumberOfHomogenousSubstrings {

	public int countHomogenous(String s) {
		long count = 0l;
		int MOD = 1000000007;

		for (int i = 0; i < s.length();) {

			long c = 0l;
			int j = i;
			while (j < s.length() && s.charAt(i) == s.charAt(j)) {
				c = c + (j - i + 1);
				j++;
			}
			i = j;
			count = (count + c) % MOD;
		}

		return (int) count % MOD;
	}

}
