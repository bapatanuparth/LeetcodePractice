package leetcodeGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.
//
//You are given two arrays redEdges and blueEdges where:
//
//redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
//blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
//Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.
public class ShortestPathWithAlternatingColors {

	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		Map<Integer, List<List<Integer>>> adj = new HashMap<>();
		for (int[] redEdge : redEdges) {
			adj.computeIfAbsent(redEdge[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(redEdge[1], 0));
		}

		for (int[] blueEdge : blueEdges) {
			adj.computeIfAbsent(blueEdge[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(blueEdge[1], 1));
		}

		int[] answer = new int[n];
		Arrays.fill(answer, -1);
		boolean[][] visit = new boolean[n][2];
		Queue<int[]> q = new LinkedList<>();

		// Start with node 0, with number of steps as 0 and undefined color -1.
		q.offer(new int[] { 0, 0, -1 });
		answer[0] = 0;
		visit[0][1] = visit[0][0] = true;

		while (!q.isEmpty()) {
			int[] element = q.poll();
			int node = element[0], steps = element[1], prevColor = element[2];

			if (!adj.containsKey(node)) {
				continue;
			}

			for (List<Integer> nei : adj.get(node)) {
				int neighbor = nei.get(0);
				int color = nei.get(1);
				if (!visit[neighbor][color] && color != prevColor) {
					if (answer[neighbor] == -1)
						answer[neighbor] = 1 + steps;
					visit[neighbor][color] = true;
					q.offer(new int[] { neighbor, 1 + steps, color });
				}
			}
		}
		return answer;
	}
}
