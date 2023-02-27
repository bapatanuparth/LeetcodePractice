package leetcodeInterviewPrep;

//You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//
//On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
//
//Find and return the maximum profit you can achieve.
public class BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
		int maxprofit = 0;
		for (int i = 0; i < prices.length;) {
			// count all the times when u get ascending stocks
			// increment maximum till the time when stock on next day is > max stock till
			// now
			int max = prices[i];
			int j = i + 1;
			while (j < prices.length && prices[j] > max) {
				max = prices[j];
				j++;
			}
			// add the difference in max profit till now
			maxprofit += prices[j - 1] - prices[i];
			i = j;
		}

		return maxprofit;
	}
}
