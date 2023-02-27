package leetcodeDynamicProgramming;

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

//Input: prices = [7,1,5,3,6,4]
//Output: 5
public class BestTimeToBuySellStock {

	 public int maxProfit(int[] prices) {
	        int low=prices[0];
	        int max_profit=0;
	        
	        for(int i=1;i<prices.length;i++){
	            low=Math.min(low, prices[i]); //if we find a lower price, we update the price to that value
	            max_profit=Math.max(max_profit, prices[i]-low); //we keep track of max profit we got yet
	        }
	        
	        return max_profit;
	    }
}
