package leetcodeDynamicProgramming;

import java.util.Arrays;

//There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:
//
//Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
//Paste: You can paste the characters which are copied last time.
//Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.

public class TwoKeysKeyboard {

	public int minSteps(int n) {
		if (n == 1)
			return 0;
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (j == 1)
					dp[i] = i;
				else if (i % j == 0) {
					int div = i / j;
					dp[i] = Math.min(dp[i], dp[j] + div);
				}
			}
		}
		return dp[n];
	}

}
