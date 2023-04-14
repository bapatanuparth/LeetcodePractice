package leetcodeDynamicProgramming;

//You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
//
//Train tickets are sold in three different ways:
//
//a 1-day pass is sold for costs[0] dollars,
//a 7-day pass is sold for costs[1] dollars, and
//a 30-day pass is sold for costs[2] dollars.
//The passes allow that many days of consecutive travel.
//
//For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
//Return the minimum number of dollars you need to travel every day in the given list of days.

public class MinCostForTickets {

	public int mincostTickets(int[] days, int[] costs) {

		int lastday = days[days.length - 1];
		int dp[] = new int[lastday + 1];

		boolean[] isTravelDay = new boolean[lastday + 1];

		for (int i : days)
			isTravelDay[i] = true;

		for (int i = 1; i <= lastday; i++) {
			if (isTravelDay[i] == false) {
				dp[i] = dp[i - 1];
				continue;
			}

			dp[i] = costs[0] + dp[i - 1];
			dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]);
			dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]);
		}

		return dp[lastday];
	}

}
