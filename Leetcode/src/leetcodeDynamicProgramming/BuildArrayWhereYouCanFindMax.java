package leetcodeDynamicProgramming;

//LC1420

public class BuildArrayWhereYouCanFindMax {

	Integer[][][] dp;

	public int numOfArrays(int n, int m, int k) {
		dp = new Integer[n + 1][m + 1][k + 1];
		return dfs(n, m, k, 0, 0, 0);
	}

	int dfs(int n, int m, int k, int i, int currMax, int currCost) {
		if (i == n) {
			if (k == currCost)
				return 1;
			return 0;
		}

		if (dp[i][currMax][currCost] != null)
			return dp[i][currMax][currCost];

		int ans = 0;
		for (int num = 1; num <= m; num++) {
			int newCost = currCost;
			int newMax = currMax;
			if (num > currMax) {
				newCost++;
				newMax = num;
			}
			if (newCost > k)
				break;
			ans += dfs(n, m, k, i + 1, newMax, newCost);
			ans = ans % 1000000007;
		}

		return dp[i][currMax][currCost] = ans;
	}

}
