package leetcodeGraphs;

import java.util.ArrayList;
import java.util.List;

//You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
//
//Return the number of connected components in the graph.
public class NoOfConnectedComponents {

	// DFS to mark all the connected components
	// count everytime u call dfs on unvisited node
	// because new call will be made only if the node is not previously marked in
	// the dfs
	public int countComponents(int n, int[][] edges) {

		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		int count = 0;
		boolean visited[] = new boolean[n];
		for (int i = 0; i < adj.size(); i++) {

			if (visited[i] == false) {
				count++;
				dfs(adj, i, visited);
			}
		}

		return count;
	}

	void dfs(List<List<Integer>> adj, int i, boolean[] visited) {

		visited[i] = true;

		for (int v : adj.get(i)) {

			if (visited[v] == false) {
				dfs(adj, v, visited);
			}
		}

	}
}
