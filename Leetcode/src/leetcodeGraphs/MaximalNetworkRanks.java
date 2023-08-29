package leetcodeGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.
//
//The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.
//
//The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
//
//Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.

public class MaximalNetworkRanks {

	public int maximalNetworkRank(int n, int[][] roads) {
		List<Set<Integer>> adj = new ArrayList<>();
		int[] degree = new int[n];

		for (int i = 0; i < n; i++) {
			adj.add(new HashSet<>());
		}

		for (int[] road : roads) {
			int a = road[0];
			int b = road[1];
			adj.get(a).add(b);
			adj.get(b).add(a);

			degree[a]++;
			degree[b]++;
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = degree[i] + degree[j];
				if (adj.get(i).contains(j))
					sum--;
				max = Math.max(max, sum);
			}
		}

		return max;
	}

}
