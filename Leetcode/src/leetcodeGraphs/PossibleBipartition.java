package leetcodeGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition {

	// assign colors to nodes, red and blue
	// in DFS go on assigning alternating colors to adjacent nodes
	// if u find an adjacent node that is already colored with same color as the
	// current node, then it is not possible to form a group of 2
	// the graph is not bipartite
	public boolean possibleBipartition(int n, int[][] dislikes) {

		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] arr : dislikes) {
			adj.get(arr[0]).add(arr[1]);
			adj.get(arr[1]).add(arr[0]);
		}
		int color[] = new int[n + 1];
		Arrays.fill(color, -1);

		for (int i = 1; i <= n; i++) {
			if (color[i] == -1) {
				if (!dfs(adj, i, 0, color))
					return false;
			}

		}

		return true;

	}

	boolean dfs(List<List<Integer>> adj, int src, int nodeColor, int[] color) {

		color[src] = nodeColor;

		for (int i : adj.get(src)) {
			if (color[i] == color[src])
				return false;
			if (color[i] == -1) {
				if (!dfs(adj, i, 1 - nodeColor, color))
					return false;
			}
		}
		return true;
	}
}
