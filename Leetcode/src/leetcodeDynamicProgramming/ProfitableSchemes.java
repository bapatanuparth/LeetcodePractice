package leetcodeDynamicProgramming;

import java.util.Arrays;

//There is a group of n members, and a list of various crimes they could commit. The ith crime generates a profit[i] and requires group[i] members to participate in it. If a member participates in one crime, that member can't participate in another crime.
//
//Let's call a profitable scheme any subset of these crimes that generates at least minProfit profit, and the total number of members participating in that subset of crimes is at most n.
//
//Return the number of schemes that can be chosen. Since the answer may be very large, return it modulo 109 + 7.
public class ProfitableSchemes {

	// 3D DP problem
	int mod = 1000000007;
	int[][][] memo = new int[101][101][101];

	int find(int pos, int count, int profit, int n, int minProfit, int[] group, int[] profits) {
		if (pos == group.length) {
			// If profit exceeds the minimum required; it's a profitable scheme.
			return profit >= minProfit ? 1 : 0;
		}

		if (memo[pos][count][profit] != -1) {
			// Repeated subproblem, return the stored answer.
			return memo[pos][count][profit];
		}

		// Ways to get a profitable scheme without this crime.
		int totalWays = find(pos + 1, count, profit, n, minProfit, group, profits);
		if (count + group[pos] <= n) {
			// Adding ways to get profitable schemes, including this crime.
			// we take math.min because even if we go past minprofit, we want max profit to
			// be considered to be minProfit
			totalWays += find(pos + 1, count + group[pos], Math.min(minProfit, profit + profits[pos]), n, minProfit,
					group, profits);
		}

		return memo[pos][count][profit] = totalWays % mod;
	}

	public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
		// Initializing all states as -1.
		for (int i = 0; i <= group.length; i++) {
			for (int j = 0; j <= n; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}

		return find(0, 0, 0, n, minProfit, group, profit);
	}

}
