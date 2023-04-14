package leetcodeGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.
//
//You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.
//
//A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.
//
//Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

public class LargestColorValueDirectedGraph {

//	Create a GraphNode class with integer value and an ArrayList of neighboring nodes. This class will be used to represent each node in the graph.
//
//	Initialize an array of GraphNode objects of size n, where n is the length of the colors string. Each GraphNode object will have a unique integer value and an empty ArrayList of neighbors.
//
//	Iterate over the edges array and for each edge, add the corresponding nodes to each other's ArrayList of neighbors. Also, keep track of the indegree of each node, i.e., the number of incoming edges for that node.
//
//	Initialize a 2D array "count" of size n x 26, where n is the number of nodes in the graph and 26 represents the 26 possible colors. This array keeps track of the count of each color along the path leading to that node. - - Initialize the array with 1 in the position corresponding to the node's own color.
//
//	Add all nodes with indegree 0 to a queue and initialize a visited counter to 0.
//
//	Start a while loop until the queue is empty. In each iteration, dequeue a node from the queue, increment the visited counter and iterate over its neighbors.
//
//	For each neighbor, iterate over the 26 possible colors, and update its count by taking the maximum between the current count and the count of the current node plus 1 if the neighbor's color matches the current color. This is essentially a dynamic programming step.
//
//	Decrement the indegree of the neighbor node and add it to the queue if its indegree becomes 0.
//
//	Also, keep track of the maximum count seen so far in a maxLength variable.
//
//	Finally, return the maximum count if all nodes are visited or -1 if some nodes are not visited. This ensures that all nodes are reachable from some node with indegree 0.

	public int largestPathValue(String s, int[][] edges) {

		int n = s.length();
		int[][] col = new int[n][26];

		int indegree[] = new int[n];

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			indegree[edge[1]]++;
		}

		Queue<Integer> q = new ArrayDeque<>();
		int visited = 0;
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				q.add(i);
				col[i][s.charAt(i) - 'a']++;
			}
		}

		int max = 0;
		while (!q.isEmpty()) {
			int ind = q.poll();
			visited++;

			for (int neighbor : adj.get(ind)) {

				for (int j = 0; j < 26; j++) {
					if (s.charAt(neighbor) - 'a' == j)
						col[neighbor][j] = Math.max(col[neighbor][j], col[ind][j] + 1);
					else
						col[neighbor][j] = Math.max(col[neighbor][j], col[ind][j]);
				}
				indegree[neighbor]--;
				if (indegree[neighbor] == 0) {
					q.add(neighbor);
				}
			}

			max = Math.max(max, Arrays.stream(col[ind]).max().getAsInt());
		}
		return visited == n ? max : -1;
	}

}
