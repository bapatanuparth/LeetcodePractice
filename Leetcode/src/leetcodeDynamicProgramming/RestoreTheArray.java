package leetcodeDynamicProgramming;

//A program was supposed to print an array of integers. The program forgot to print whitespaces and the array is printed as a string of digits s and all we know is that all integers in the array were in the range [1, k] and there are no leading zeros in the array.
//
//Given the string s and the integer k, return the number of the possible arrays that can be printed as s using the mentioned program. Since the answer may be very large, return it modulo 109 + 7.

public class RestoreTheArray {
	// dfs+memo

	Integer dp[];

	public int numberOfArrays(String s, int k) {
		dp = new Integer[s.length() + 1];
		return dfs(0, s, k);
	}

	int dfs(int start, String s, int k) {

		if (start == s.length()) {
			return 1;
		}

		if (dp[start] != null)
			return dp[start];

		int count = 0;
		for (int i = start; i < s.length(); i++) {
			String sub = s.substring(start, i + 1);
			if (sub.charAt(0) == '0')
				break;
			if (Long.parseLong(sub) > (long) k)
				break;
			count += dfs(i + 1, s, k);
			count = count % 1000000007;
		}

		return dp[start] = count;
	}

}
