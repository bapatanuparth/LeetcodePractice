package leetcodeGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//use bellman-ford algorithm
public class CheapestFlightsWithKStops {

	// Bellman - ford
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		// store the cost required to reach all the destinations
		// initially as MAX_VALUE
		// only cost to reach src will be 0
		int[] prices = new int[n];
		Arrays.fill(prices, Integer.MAX_VALUE);
		prices[src] = 0;

		for (int i = 0; i <= k; i++) {
			int[] tmpPrices = Arrays.copyOf(prices, prices.length);

			// at each iteration, we consider all the edges of the graph and go to only
			// those which we are able to reach
			for (int[] flight : flights) {
				int s = flight[0];
				int d = flight[1];
				int cost = flight[2];

				if (prices[s] == Integer.MAX_VALUE) // if current source is not reachable
					continue;
				if (prices[s] + cost < tmpPrices[d]) // cost to reach the current destination d from current src s, is
														// prices to reach to that s + cost of current travel to d
				// if it is < the current price to reach dest d
				{
					tmpPrices[d] = prices[s] + cost;
				}
			}

			prices = tmpPrices;
		}

		return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];

	}

	// my code with DFS gives TLE
	int res = Integer.MAX_VALUE;

	public int findCheapestPriceDFS(int n, int[][] flights, int src, int dst, int k) {

		List<List<int[]>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] flight : flights) {
			int s = flight[0];
			int d = flight[1];
			int c = flight[2];

			graph.get(s).add(new int[] { d, c });
		}
		boolean[] vis = new boolean[n];
		dfs(graph, src, dst, 0, vis, k);

		return res == Integer.MAX_VALUE ? -1 : res;
	}

	void dfs(List<List<int[]>> graph, int src, int dest, int cost, boolean[] vis, int k) {

		if (src == dest) {
			res = Math.min(res, cost);
			return;
		}

		if (k < 0) {
			return;
		}

		vis[src] = true;

		for (int[] nodes : graph.get(src)) {
			if (vis[nodes[0]] == false) {
				dfs(graph, nodes[0], dest, cost + nodes[1], vis, k - 1);
			}
		}

		vis[src] = false;
	}

}
