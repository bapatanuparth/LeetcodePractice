package leetcode150daysDynamicProgramming;

import java.util.Arrays;

//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
//Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
//You may assume that you have an infinite number of each kind of coin.

public class CoinChange {

	// int memo[][]= new int[13][10001];
	public int coinChange(int[] coins, int amount) {
		int dp[] = new int[amount + 1];
		// 0 1 1 2 2 1
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

}
