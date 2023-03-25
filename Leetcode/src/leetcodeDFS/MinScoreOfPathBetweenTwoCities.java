package leetcodeDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.
//
//The score of a path between two cities is defined as the minimum distance of a road in this path.
//
//Return the minimum possible score of a path between cities 1 and n.
//
//Note:
//
//A path is a sequence of roads between two cities.
//It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
//The test cases are generated such that there is at least one path between 1 and n.

public class MinScoreOfPathBetweenTwoCities {

	// as it is guaranteed that there exists a path between 1 to n, just get all the
	// connected components of 1 using DFS and find the minimum edge of that island.
	// this will be the smallest road along the path from 1 to N since we are
	// considering all the connected components of 1

	int ans = Integer.MAX_VALUE;

	void dfs(int node, Map<Integer, List<List<Integer>>> adj, boolean[] visited) {
		visited[node] = true;
		if (!adj.containsKey(node))
			return;
		for (List<Integer> edge : adj.get(node)) {
			ans = Math.min(ans, edge.get(1));
			if (!visited[edge.get(0)]) {
				dfs(edge.get(0), adj, visited);
			}
		}

	}

	public int minScore(int n, int[][] roads) {
		Map<Integer, List<List<Integer>>> adj = new HashMap<>();

		for (int[] road : roads) {
			adj.computeIfAbsent(road[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(road[1], road[2]));
			adj.computeIfAbsent(road[1], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(road[0], road[2]));
		}
		boolean[] visit = new boolean[n + 1];
		dfs(1, adj, visit);

		return ans;
	}
}
