package leetcode150daysGraph;

import java.util.Arrays;

//There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
//
//You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

public class CheapestFlightWithinKStops {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[] prices = new int[n];
		Arrays.fill(prices, Integer.MAX_VALUE);
		prices[src] = 0;

		for (int i = 0; i <= k; i++) {
			int[] tmpPrice = Arrays.copyOf(prices, prices.length);

			for (int[] flight : flights) {
				int s = flight[0];
				int d = flight[1];
				int price = flight[2];

				if (prices[s] == Integer.MAX_VALUE)
					continue;
				if (prices[s] + price <= tmpPrice[d]) {
					tmpPrice[d] = prices[s] + price;
				}
			}

			prices = tmpPrice;
		}

		return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
	}

}
