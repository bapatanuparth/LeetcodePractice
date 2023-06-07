package leetcodeDynamicProgramming;

//Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones. 
//
//Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
//
//On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
//
//The game continues until all the stones have been taken.
//
//Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

public class StoneGameII {
	class Solution {
		int n = 0;
		int[][][] dp;

		public int stoneGameII(int[] piles) {
			n = piles.length;
			dp = new int[2][piles.length + 1][piles.length + 1];
			// fill dp with all -1
			for (int p = 0; p < 2; p++) {
				for (int i = 0; i <= piles.length; i++) {
					for (int m = 0; m <= piles.length; m++) {
						dp[p][i][m] = -1;
					}
				}
			}
			return dfs(piles, 0, 0, 1);
		}

		// p == player, 0 for Alice and 1 for Bob
		// i, == index, M == m
		int dfs(int[] piles, int p, int i, int m) {
			if (i >= piles.length)
				return 0;
			if (dp[p][i][m] != -1)
				return dp[p][i][m];

			int res = p == 0 ? 0 : Integer.MAX_VALUE; // for bob, we want to pick the min value of res, and for alice we
														// want to pick the max value of res
			int tempsum = 0;
			for (int x = 1; x <= 2 * m; x++) {
				if (i + x > n)
					break;
				tempsum += piles[i + x - 1];
				if (p == 0) {
					res = Math.max(res, tempsum + dfs(piles, 1 - p, i + x, Math.max(m, x))); // alice wants to maximize
																								// the result she gets
				} else {
					// we dopnt add tempsum here because we have defined dfs to return the number of
					// stones that alice gets. hence, we cannot add the stones picked up by bob here

					res = Math.min(res, dfs(piles, 1 - p, i + x, Math.max(m, x))); // bob wants to minimize the stones
																					// that alice gets. so if its bob's
																					// turn, we try to minimize the
																					// result.
				}
			}
			dp[p][i][m] = res;
			return dp[p][i][m];
		}
	}

}
