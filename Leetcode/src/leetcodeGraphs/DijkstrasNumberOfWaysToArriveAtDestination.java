package leetcodeGraphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasNumberOfWaysToArriveAtDestination {

//	You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
//
//	You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
//
//	Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

	int MOD = 1000000007;

	public int countPaths(int n, int[][] roads) {
		int[][] grid = new int[n][n];
		// store the minimum distance to reach every node
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		// dist to reach 0
		dist[0] = 0;

		// construct adjacency matrix
		for (int[] road : roads) {
			int i = road[0];
			int j = road[1];
			grid[i][j] = road[2];
			grid[j][i] = road[2];
		}
		// dp will store the ways to reach each node from zero
		long[] dp = new long[n];
		dp[0] = 1; // 1 way to r4each the node 0

		// priorityQueue ensures that we pick the closest node everytime
		// essential for dijkstra's algorithm
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] { 0, 0 });

		while (!pq.isEmpty()) {
			int top[] = pq.poll();
			// current Node and distance to reach current node
			int currNode = top[0], currDist = top[1];
			if (currDist > dist[currNode]) // if curr distance > shortest distance to reach this node, we ignore this
				continue;
			for (int i = 0; i < n; i++) {
				if (grid[currNode][i] != 0) { // edge exists

					// if shortest distance to reach i > the new shortest distance with parent ==
					// currNode
					if (dist[i] > dist[currNode] + grid[currNode][i]) {
						// update the shortest distance to reach the ith node
						dist[i] = dist[currNode] + grid[currNode][i];
						dp[i] = dp[currNode]; // new parent to reach ith node, so #of ways to reach here is same as the
												// parent
						dp[i] %= MOD;
						pq.offer(new int[] { i, dist[i] });
					}
					// if theres a tie for shortest distance from different parents, we have found a
					// new set of ways through a different parent
					else if (dist[i] == dist[currNode] + grid[currNode][i]) {
						dp[i] += dp[currNode]; // currNode also parent of the ith node
						dp[i] %= MOD;
					}
				}
			}
		}

		return (int) dp[n - 1];
	}

}
