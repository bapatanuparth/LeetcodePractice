package leetcodeDFS;

import java.util.ArrayList;
import java.util.List;

//You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.

//
//Return the number of pairs of different nodes that are unreachable from each other.

public class CountUnreachablePairsNodesGraph {

	long count = 0;

	public long countPairs(int n, int[][] edges) {

		// create adjacency list
		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int edge[] : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		boolean[] visited = new boolean[n];
		List<Long> res = new ArrayList<>();

		// perform dfs and count size of each island
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(adj, i, visited);
				res.add(count);
				count = 0;
			}
		}

		if (res.size() == 1)
			return 0;

		// for each island, calculate the total number of pairs based on total size-
		// island size
		long total = (long) n;
		long val = 0;
		long prev = 0;
		for (int i = 0; i < res.size() - 1; i++) {
			long size = res.get(i);
			val += size * (total - size);
			total -= size;
		}

		return val;

	}

	// basic dfs
	void dfs(List<List<Integer>> adj, int src, boolean visited[]) {
		visited[src] = true;
		count++;

		for (int next : adj.get(src)) {
			if (visited[next] == false) {
				dfs(adj, next, visited);
			}
		}
	}

}
