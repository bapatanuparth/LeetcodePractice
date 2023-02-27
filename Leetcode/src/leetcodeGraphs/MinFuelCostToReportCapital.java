package leetcodeGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DFS
//
//Imagine you are at a leaf node, you move towards 0. There will be only 1 person in the car (you)
//Now let's say you're somewhere in the middle of the tree, with a car of size 5. You have 3 children nodes. Let's say each child node brings 1 car of 3 people. So a total of 3 * 3 = 9 people. Including you there are 10 people now. Now you have 3 cars from the child nodes and one car of your own. You actually need just 10 / 5 = 2 cars. You take 2 cars and move towards 0
public class MinFuelCostToReportCapital {

	class Solution {
		long fuel;

		public long dfs(int node, int parent, Map<Integer, List<Integer>> adj, int seats) {
			// The node itself has one representative.
			int representatives = 1;
			if (!adj.containsKey(node)) {
				return representatives;
			}
			for (int child : adj.get(node)) {
				if (child != parent) {
					// Add count of representatives in each child subtree to the parent subtree.
					representatives += dfs(child, node, adj, seats);
				}
			}
			if (node != 0) {
				// Count the fuel it takes to move to the parent node.
				// Root node does not have any parent so we ignore it.
				fuel += Math.ceil((double) representatives / seats);
			}
			return representatives;
		}

		public long minimumFuelCost(int[][] roads, int seats) {
			Map<Integer, List<Integer>> adj = new HashMap<>();
			for (int[] road : roads) {
				adj.computeIfAbsent(road[0], k -> new ArrayList<Integer>()).add(road[1]);
				adj.computeIfAbsent(road[1], k -> new ArrayList<Integer>()).add(road[0]);
			}
			dfs(0, -1, adj, seats);
			return fuel;
		}
	}
}
