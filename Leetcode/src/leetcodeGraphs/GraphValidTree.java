package leetcodeGraphs;

import java.util.ArrayList;
import java.util.List;

//You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
//
//Return true if the edges of the given graph make up a valid tree, and false otherwise.

public class GraphValidTree {

	public boolean validTree(int n, int[][] edges) {

		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		boolean[] vis = new boolean[n];
		for (int i = 0; i < edges.length; i++) {

			int temp[] = edges[i];

			adj.get(temp[0]).add(temp[1]);
			adj.get(temp[1]).add(temp[0]);
		}

		if (dfs(adj, vis, 0, -1))
			return false;

		// check if graph was disconnected
		for (boolean v : vis) {
			if (v == false)
				return false;
		}

		return true;
	}

	// cycel detection for undirected graph
	boolean dfs(List<List<Integer>> adj, boolean[] visited, int i, int parent) {

		visited[i] = true;

		for (int j : adj.get(i)) {

			if (visited[j] == false) {
				if (dfs(adj, visited, j, i))
					return true;
			} else if (j != parent)
				return true;
		}

		return false;
	}
}
