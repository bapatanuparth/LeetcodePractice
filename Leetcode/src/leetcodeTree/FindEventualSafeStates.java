package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

	class Solution {
		Boolean res[];

		public List<Integer> eventualSafeNodes(int[][] graph) {
			int n = graph.length;

			res = new Boolean[n];
			boolean visited[] = new boolean[n];
			for (int i = 0; i < n; i++) {
				dfs(graph, i, visited);
			}

			List<Integer> result = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (res[i] != null)
					result.add(i);
			}
			return result;
		}

		// dfs to check whether safe or not
		boolean dfs(int[][] graph, int st, boolean[] visited) {
			// mark each node as safe
			boolean safe = true;
			// if this node is already safe, then return true
			if (res[st] != null) {
				return res[st];
			}
			// if this node was already visited, it means we are in a cycle, return false.
			if (visited[st])
				return false;
			// visit the current node
			visited[st] = true;
			// visit all the edges and check if any of them returns false
			for (int e : graph[st]) {
				safe = safe && dfs(graph, e, visited);
			}
			// if all returned true, it means we are good to mark this as safe
			if (safe) {
				res[st] = true;
				return true;
			}
			// else return false
			return false;
		}
	}
}
