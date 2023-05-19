package leetcodeUnionFind;

import java.util.Arrays;

//Alice and Bob have an undirected graph of n nodes and three types of edges:
//
//Type 1: Can be traversed by Alice only.
//Type 2: Can be traversed by Bob only.
//Type 3: Can be traversed by both Alice and Bob.
//Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.
//
//Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.

public class RemoveMaxEdgesToKeepGraphFullyTraversable {
	class Solution {

		// we want to remove maximum edges
		// so we choose toi keep all the edges of type 3 as type 3 edges can be used by
		// both A and B.
		// in this way we are connecting 2 nodes for both A and B in a single edge

		// Algo-
		// sort by edge type.
		// pick edges of type 3 first
		// create a DSU for A and B separately keeping track of how many nodes are
		// connected for both
		// while considering eacch edge check if nodes are already connected, if yes
		// remove that edge if no take that edge
		// count all the edges removed by now
		public int maxNumEdgesToRemove(int n, int[][] edges) {

			Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0])); // sort based on type of edge
			// we want to consider all edges of type 3 first while forming DSU so that we
			// remove max number of edges

			int[] parenta = new int[n + 1]; // parents of each node for graph of alice
			int[] parentb = new int[n + 1]; // parent of each node for graph of bob
			int[] ranka = new int[n + 1]; // rank i.e. number of nodes connected to a node of each node for graph in
											// alice
			int[] rankb = new int[n + 1]; // number of nodes connected to a node in graph of bob

			int removedEdges = 0;
			int grapha = 1; // total number of connected nodes for alice
			int graphb = 1; // total number of connected nodes for bob

			for (int i = 0; i < parenta.length; i++) {
				parenta[i] = i; // each node is parent of itself
				parentb[i] = i;
				ranka[i] = 1; // rank of each node is 1, i.e. conected to only itself
				rankb[i] = 1;
			}

			for (int[] e : edges) {
				if (e[0] == 3) { // the edge that can be traverse by both A and B
					boolean mergeda = union(e[1], e[2], parenta, ranka); // consider graph for alice
					boolean mergedb = union(e[1], e[2], parentb, rankb); // consider graph for bob

					if (mergeda == true) {
						grapha++; // new node was connected in grapha
					}
					if (mergedb == true)
						graphb++; // new node was merged in graphb

					if (mergeda == false && mergedb == false) // if the 2 nodes were not merged in any graph, i.e. the
																// parents of 2 nodes were already connected, then it is
																// safe to remove this edge
						removedEdges++;

				} else if (e[0] == 1) { // the edge type is the one that can be traversed only by alice
					boolean mergeda = union(e[1], e[2], parenta, ranka); // consider graph for alice
					if (mergeda == true) {
						grapha++; // new node was connected in grapha
					} else
						removedEdges++;
				} else {
					boolean mergedb = union(e[1], e[2], parentb, rankb); // consider graph for bob
					if (mergedb == true)
						graphb++; // new node was merged in graphb
					else
						removedEdges++;
				}
			}

			if (grapha != n || graphb != n) // if either graph of A or B remains disconnected
				return -1;
			else
				return removedEdges;
		}

		public boolean union(int x, int y, int parent[], int[] rank) {
			int px = find(x, parent); // find parent of x
			int py = find(y, parent); // find parent of y

			if (px == py)
				return false;
			else {
				// this is optimization of union by rank i.e. depth of the chain
				// choose the one with greater rank / depth. height of chain.
				if (rank[px] > rank[py]) { // rank of parent of x > py, make px as a parent of py
					parent[py] = px;

				} else if (rank[px] < rank[py]) { // rank of parent y > px, make py as a parent of px
					parent[px] = py;
				} else {
					parent[px] = py;
					rank[py]++;
				}
				return true;
			}
		}

//find parent of a node x
		public int find(int x, int[] parent) {
			if (parent[x] == x)
				return x;
			int temp = find(parent[x], parent);
			parent[x] = temp; // this is path compression,update the parent of current node x if there has
								// been any change in the upper order so that we dont make many recursive calls
								// again and again to reach the top level
			return temp;
		}
	}

}
