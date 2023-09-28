package leetcode150daysDFS;

import java.util.ArrayList;
import java.util.List;

//There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.
//
//You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
//
//Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

public class NumberOperationsMakeNetworkConnected {

	public int makeConnected(int n, int[][] connections) {
		// minimum edges in graph should be n-1
		// so if currently ghraph doesnt have as many edges, then it will never be fully
		// connected
		if (connections.length < n - 1)
			return -1;
		// make adjacency list
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] arr : connections) {
			adj.get(arr[0]).add(arr[1]);
			adj.get(arr[1]).add(arr[0]);
		}
		boolean[] visited = new boolean[n];

		// run simple dfs to count number of connected components
		int components = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(adj, visited, i);
				components++;
			}
		}
		return components - 1;

	}

	void dfs(List<List<Integer>> adj, boolean visited[], int src) {
		visited[src] = true;

		for (int neighbor : adj.get(src)) {
			if (visited[neighbor] == false)
				dfs(adj, visited, neighbor);
		}
	}

}
