package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

//You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).
//
//The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.
//
//Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.
//
//A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.

public class NumberOfNodesInSubtreeWithSameLabel {

	public int[] countSubTrees(int n, int[][] edges, String labels) {
		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());

		for (int i = 0; i < edges.length; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}

		boolean[] vis = new boolean[n];
		int[] res = new int[n];
		int freq[] = new int[26];

		dfs(adj, labels, 0, -1, res, vis);
		return res;

	}

	// we return frequence if character occurrences at each subtree level
	// so after each child is processed, in parent, we update the frequency array of
	// parent based on all frequencies arrays returned by multiple children
	// then change the result for that particular node while going up in recursion
	// stack
	// then return the frequency array that represents all the frequencies of all
	// the characters below that node taken as root
	int[] dfs(List<List<Integer>> adj, String labels, int node, int parent, int res[], boolean[] vis) {

		vis[node] = true;
		int arr[] = new int[26];
		arr[labels.charAt(node) - 'a'] = 1;

		for (int child : adj.get(node)) {
			if (child == parent)
				continue;

			if (vis[child] == false) {
				int[] freq = dfs(adj, labels, child, node, res, vis);
				for (int i = 0; i < 26; i++) {
					arr[i] += freq[i];
				}
			}
		}

		res[node] = arr[labels.charAt(node) - 'a'];
		return arr;

	}

}
