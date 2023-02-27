package leetcodeGraphs;

import java.util.ArrayList;
import java.util.List;

//There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
//
//You want to determine if there is a valid path that exists from vertex source to vertex destination.
//
//Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

//Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
//Output: false

public class ValidPath {

	// convert the in[][] to an adjacency matrix and then perform dfs on that to
	// check if path exists
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		// convert to adj list
		for (int i = 0; i < edges.length; i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}

		boolean[] visited = new boolean[n];

		// dfs on adj list
		return dfs(graph, source, destination, visited);
	}

	boolean dfs(List<List<Integer>> graph, int source, int dest, boolean[] visited) {
		if (source == dest)
			return true;

		List<Integer> temp = graph.get(source);

		visited[source] = true;

		for (int i = 0; i < temp.size(); i++) {

			if (visited[temp.get(i)] == false) {
				if (dfs(graph, temp.get(i), dest, visited))
					return true;
			}

		}
		return false;

	}
}
