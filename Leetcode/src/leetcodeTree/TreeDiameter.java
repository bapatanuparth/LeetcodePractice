package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

//The diameter of a tree is the number of edges in the longest path in that tree.
//
//There is an undirected tree of n nodes labeled from 0 to n - 1. You are given a 2D array edges where edges.length == n - 1 and edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the tree.
//
//Return the diameter of the tree.

public class TreeDiameter {

	int diameter = 0;

	public int treeDiameter(int[][] edges) {
		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i <= edges.length; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] arr : edges) {
			adj.get(arr[0]).add(arr[1]);
			adj.get(arr[1]).add(arr[0]);
		}

		dfs(adj, 0, -1);
		return diameter;
	}

	int dfs(List<List<Integer>> adj, int src, int parent) {
		int maxDist1 = 0, maxDist2 = 0; // represent the highest and second highest distance traveled detween 2 nodes
										// from a parent

		for (int child : adj.get(src)) {
			if (child == parent)
				continue; // continue if child == parent

			int childDepth = dfs(adj, child, src); // calculate depth of a child

			if (childDepth > maxDist1) {
				maxDist2 = maxDist1;
				maxDist1 = childDepth;
			} else if (childDepth > maxDist2) {
				maxDist2 = childDepth;
			}
		}

		diameter = Math.max(diameter, maxDist1 + maxDist2);

		return maxDist1 + 1;
	}
}
