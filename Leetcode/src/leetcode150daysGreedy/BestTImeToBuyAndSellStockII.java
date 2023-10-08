package leetcode150daysGreedy;

//You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//
//On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
//
//Find and return the maximum profit you can achieve.

public class BestTImeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
		int maxprofit = 0;
		for (int i = 0; i < prices.length;) {
			int max = prices[i];
			int j = i + 1;
			while (j < prices.length && prices[j] > max) {
				max = prices[j];
				j++;
			}
			maxprofit += prices[j - 1] - prices[i];
			i = j;
		}

		return maxprofit;
	}

}
