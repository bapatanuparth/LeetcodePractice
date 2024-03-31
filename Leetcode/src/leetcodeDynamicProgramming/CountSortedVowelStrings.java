package leetcodeDynamicProgramming;

import java.util.Arrays;

//Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
//
//A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

public class CountSortedVowelStrings {

	int memo[][];

	public int countVowelStrings(int n) {
		memo = new int[n + 1][6];
		for (int i = 0; i <= n; i++)
			Arrays.fill(memo[i], -1);
		return dfs(n, 5); // a e i o u can be 5 different values.
	}

	int dfs(int n, int prev) {
		// a==5, b==4, i==3, o==2, u==1
		// this prev represents which was the previous letter that we got here from
		if (n == 0)
			return 1;

		if (memo[n][prev] != -1)
			return memo[n][prev];

		int number = 0;
		// if we start from a, we can have all the letters till 1 added after a
		// and still the lexicographical order will be correct
		for (int i = prev; i >= 1; i--) {
			number += dfs(n - 1, i);
		}

		return memo[n][prev] = number;
	}

}
