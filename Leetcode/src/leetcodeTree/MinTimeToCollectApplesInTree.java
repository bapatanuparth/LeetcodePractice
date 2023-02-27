package leetcodeTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect all apples in the tree, starting at vertex 0 and coming back to this vertex.
//
//The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.

public class MinTimeToCollectApplesInTree {

	public int dfs(int node, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
		if (!adj.containsKey(node))
			return 0;

		int totalTime = 0, childTime = 0;
		for (int child : adj.get(node)) {
			if (child == parent)
				continue;
			childTime = dfs(child, node, adj, hasApple);
			// childTime > 0 indicates subtree of child has apples. Since the root node of
			// the
			// subtree does not contribute to the time, even if it has an apple, we have to
			// check it
			// independently.
			if (childTime > 0 || hasApple.get(child))
				totalTime += childTime + 2;
		}
		return totalTime;
	}

	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for (int[] edge : edges) {
			int a = edge[0], b = edge[1];
			adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
			adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
		}
		return dfs(0, -1, adj, hasApple);
	}

}
