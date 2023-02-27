package leetcodeDynamicProgramming;

import java.util.Arrays;
//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
//Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
//You may assume that you have an infinite number of each kind of coin.

public class CoinChange {

	// easier tabulation method
	public int coinChangeEff(int[] coins, int amount) {
		int dp[] = new int[amount + 1];

		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {

			for (int val : coins) {
				if (val <= i) {
					dp[i] = Math.min(dp[i - val] + 1, dp[i]);
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
	}

	// create memo based on given condition
	int memo[][] = new int[13][10001];

	public int coinChange(int[] coins, int amount) {

		for (int[] ar : memo) {
			Arrays.fill(ar, -1);
		}
		int minCoins = coinChanger(coins, amount, coins.length);

		return (minCoins == Integer.MAX_VALUE - 1) ? -1 : minCoins;

	}

	public int coinChanger(int[] coins, int amount, int n) {

		if (amount == 0)
			return 0;

		if (n == 0)
			return Integer.MAX_VALUE - 1;

		if (memo[n][amount] != -1)
			return memo[n][amount];

		// we have 2 choices -->
		// 1. either include current coin in the sum or exclude current coin from the
		// sum
		if (coins[n - 1] <= amount) {
			// we choose the min value of including the coin or excluding it
			return memo[n][amount] = Math.min(coinChanger(coins, amount, n - 1),
					1 + coinChanger(coins, amount - coins[n - 1], n));
		}

		// if the coin !< than amount, we have no option but to exclude it from the sum
		return memo[n][amount] = coinChanger(coins, amount, n - 1);
	}
}
