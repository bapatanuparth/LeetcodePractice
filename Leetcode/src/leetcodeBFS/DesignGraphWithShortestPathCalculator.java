package leetcodeBFS;

import java.util.PriorityQueue;
import java.util.Queue;

//There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1. The edges of the graph are initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti] meaning that there is an edge from fromi to toi with the cost edgeCosti.
//
//Implement the Graph class:
//
//Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.
//addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost]. It is guaranteed that there is no edge between the two nodes before adding this one.
//int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2. If no path exists, return -1. The cost of a path is the sum of the costs of the edges in the path.

public class DesignGraphWithShortestPathCalculator {

	// Based on Dijkstra's Shortest Path

	class Node {
		int val;
		int weight;

		public Node(int v, int w) {
			val = v;
			weight = w;
		}
	}

	class Graph {

		int[][] adj;

		public Graph(int n, int[][] edges) {
			adj = new int[n][n];
			for (int[] e : edges) {
				adj[e[0]][e[1]] = e[2];
			}
		}

		public void addEdge(int[] edge) {
			adj[edge[0]][edge[1]] = edge[2];
		}

		public int shortestPath(int node1, int node2) {

			Queue<Node> q = new PriorityQueue<>((a, b) -> a.weight - b.weight);
			q.offer(new Node(node1, 0));
			boolean visited[] = new boolean[adj.length];

			while (!q.isEmpty()) {
				Node n = q.poll();
				if (visited[n.val])
					continue;

				visited[n.val] = true;
				if (n.val == node2)
					return n.weight;

				for (int i = 0; i < adj.length; i++) {
					if (adj[n.val][i] != 0) {
						q.add(new Node(i, n.weight + adj[n.val][i]));
					}
				}
			}

			return -1;
		}
	}

}
