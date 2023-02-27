package leetcodeDynamicProgramming;

//You are given an array prices where prices[i] is the price of a given stock on the ith day.

//
//Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
//
//After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
//Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

///very very tricky
public class BuyAndSellStockWithCooldown {

	class Solution {
		public int maxProfit(int[] prices) {

			int sold = Integer.MIN_VALUE;
			int held = Integer.MIN_VALUE;
			int reset = 0;

			for (int price : prices) {
				int presold = sold;

				sold = held + price;
				held = Math.max(held, reset - price);
				reset = Math.max(reset, presold);
			}

			return Math.max(sold, reset);
		}
	}
}
