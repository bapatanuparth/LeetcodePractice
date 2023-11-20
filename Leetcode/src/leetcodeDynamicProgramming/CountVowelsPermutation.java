package leetcodeDynamicProgramming;

public class CountVowelsPermutation {

	public int countVowelPermutationM2(int n) {
		int MOD = (int) (1e9 + 7);
		long[][] dp = new long[n + 1][5];
		for (int i = 0; i < 5; i++) {
			dp[1][i] = 1;
		}
		/*
		 * 0: a 1: e 2: i 3: o 4: u
		 */
		for (int i = 1; i < n; i++) {
			dp[i + 1][0] = (dp[i][4] + dp[i][1] + dp[i][2]) % MOD;
			dp[i + 1][1] = (dp[i][0] + dp[i][2]) % MOD;
			dp[i + 1][2] = (dp[i][3] + dp[i][1]) % MOD;
			dp[i + 1][3] = (dp[i][2]) % MOD;
			dp[i + 1][4] = (dp[i][2] + dp[i][3]) % MOD;
		}

		long ans = 0;
		for (int i = 0; i < 5; i++)
			ans = (ans + dp[n][i]) % MOD;
		return (int) ans;
	}

	int MOD = 1000000007;
	Long[][] dp;

	public int countVowelPermutation(int n) {
		dp = new Long[26][n + 1];
		char[] arr = new char[] { 'a', 'e', 'i', 'o', 'u' };
		int ans = 0;
		for (char ch : arr) {
			ans = (ans + (int) (dfs(n, ch))) % MOD;
		}

		return ans;
	}

	long dfs(int n, char parent) {
		if (n == 1)
			return 1;

		if (dp[parent - 'a'][n] != null)
			return dp[parent - 'a'][n];

		long ways = 0;
		if (parent == 'a') {
			ways += (dfs(n - 1, 'e')) % MOD;
		} else if (parent == 'e') {
			ways += ((dfs(n - 1, 'a')) % MOD + (dfs(n - 1, 'i'))) % MOD;
		} else if (parent == 'i') {
			ways += ((((dfs(n - 1, 'a')) % MOD + (dfs(n - 1, 'e'))) % MOD + (dfs(n - 1, 'o'))) % MOD
					+ (dfs(n - 1, 'u'))) % MOD;
		} else if (parent == 'o') {
			ways += ((dfs(n - 1, 'i')) % MOD + (dfs(n - 1, 'u'))) % MOD;
		} else if (parent == 'u') {
			ways += (dfs(n - 1, 'a')) % MOD;
		}

		return dp[parent - 'a'][n] = ways;

	}
}
