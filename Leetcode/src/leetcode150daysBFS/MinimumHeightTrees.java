package leetcode150daysBFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
//
//Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
//
//Return a list of all MHTs' root labels. You can return the answer in any order.
//
//The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

public class MinimumHeightTrees {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 0)
			return new ArrayList<>();
		if (n == 1) {
			List<Integer> ls = new ArrayList<>();
			ls.add(0);
			return ls;
		}

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		int[] degree = new int[n];
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
			degree[edge[0]]++;
			degree[edge[1]]++;
		}

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			if (degree[i] == 1)
				q.add(i);
		}

		List<Integer> res = new ArrayList<>();
		while (!q.isEmpty()) {
			res = new ArrayList<>();
			int size = q.size();
			while (size > 0) {
				int ind = q.poll();
				res.add(ind);
				for (int neigh : adj.get(ind)) {
					degree[neigh]--;
					if (degree[neigh] == 1) {
						q.add(neigh);
					}
				}
				size--;
			}
		}

		return res;
	}
}
