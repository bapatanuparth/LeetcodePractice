package leetcodeDynamicProgramming;

public class NumberofDiceRollsWithTargetSum {

	// tabulation
	public int numRollsToTargetTabulation(int n, int k, int tar) {

		// set dp for memoization
		int dp[][] = new int[n + 1][tar + 1];

		// if #of dice 0 and target 0 we can get it in 1 way
		dp[0][0] = 1;
		// init with -1
		int ans = 0;
		for (int dice = 1; dice <= n; dice++) {

			for (int target = 1; target <= tar; target++) {

				for (int i = 1; i <= k; i++) {

					ans = (ans + dp[dice - 1][target - i]) % 1000000007;
				}
				dp[dice][target] = ans;
			}
		}

		return dp[n][tar];
	}

//memoization
	public int numRollsToTarget(int n, int k, int target) {

		// set dp for memoization
		int dp[][] = new int[n + 1][target + 1];

		// init with -1
		for (int i = 0; i < dp.length; i++) {

			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}

		return solve(n, k, target, dp);
	}

	int solve(int dice, int faces, int target, int[][] dp) {

		// base cases for dice and target
		if (target < 0)
			return 0;
		if (target == 0 && dice != 0)
			return 0;
		if (dice == 0 && target != 0)
			return 0;
		if (dice == 0 && target == 0)
			return 1;

		if (dp[dice][target] != -1)
			return dp[dice][target];

		// for each faces of each dice, choose 1 face at atime and call recursively
		// ex. if u had only 2 faces with n dice, u could pick face 1 of first then face
		// 1 of first and so on till end, then all 1s only last die 2 etc
		// consider all possible cases
		int ans = 0;
		for (int i = 1; i <= faces; i++) {

			ans = (ans + solve(dice - 1, faces, target - i, dp)) % 1000000007;
		}

		return dp[dice][target] = ans;
	}
}
