package leetcodeDynamicProgramming;

//You are given two 0-indexed integer arrays of the same length present and future where present[i] is the current price of the ith stock and future[i] is the price of the ith stock a year in the future. You may buy each stock at most once. You are also given an integer budget representing the amount of money you currently have.
//
//Return the maximum amount of profit you can make.

public class MaxProfitFromTradingStocks {

	// For each new stock, we can either buy or not buy, so for each budget, we
	// check if we can buy or not buy.
	//
	// This means that the outer for loop is the stock with the inner loop being the
	// budget.
	// We will only buy a stock when doing so makes a profit.
	//
	// Let dp[i][j] be the maximum profit that can be made with budget j and 0 ~ ith
	// stock.
	// Then, we have dp[i][j] = max(dp[i-1][j - present[i]] + future[i] -
	// present[i], dp[i-1][j])
	//
	// This dp only depends on the previous row, hence we have no need for 2D dp,
	// let's write it in 1D && since j - present[i] is only ever smaller than j, we
	// can loop it backward to get rid of the need to create a tmp 1D array.
	//
	// (ps. I wrote this in my GE class so hopefully it makes sense)
	//
	// Time Complexity: O(budget * len of stock)
	// Space Complexity: O(budget)

	public int maximumProfit(int[] present, int[] future, int budget) {

		int dp[] = new int[budget + 1];

		for (int i = 0; i < present.length; i++) {

			for (int j = budget; j >= 0; j--) {
				if (j >= present[i] && present[i] < future[i])
					dp[j] = Math.max(dp[j], dp[j - present[i]] // max value at budget- present[i] + current profit
							+ future[i] - present[i]);
			}
		}

		return dp[budget];
	}
}
