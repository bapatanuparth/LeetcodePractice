package leetcodeUnionFind;

//In this problem, a tree is an undirected graph that is connected and has no cycles.
//
//You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
//
//Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

public class RedunduntConnection {

	class Solution {
		public int[] findRedundantConnection(int[][] edges) {
			DSU dsu = new DSU();
			for (int[] edge : edges) {
				if (!dsu.union(edge[0], edge[1]))
					return edge;
			}

			return new int[] {};
		}
	}

	class DSU {
		int[] parent;
		int[] rank;

		DSU() {
			parent = new int[1001];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}
			rank = new int[1001];
		}

		int find(int x) {
			if (parent[x] == x)
				return x;
			return parent[x] = find(parent[x]);
		}

		boolean union(int x, int y) {
			int px = find(x);
			int py = find(y);
			if (px == py)
				return false;
			else if (rank[px] < rank[py]) {
				parent[px] = py;
			} else if (rank[py] < rank[px]) {
				parent[py] = px;
			} else {
				parent[py] = px;
				rank[py]++;
			}
			return true;
		}
	}

}
