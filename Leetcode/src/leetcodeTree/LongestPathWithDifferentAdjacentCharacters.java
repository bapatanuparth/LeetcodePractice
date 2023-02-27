package leetcodeTree;
//You are given a tree (i.e. a connected, undirected graph that has no cycles) rooted at node 0 consisting of n nodes numbered from 0 to n - 1. The tree is represented by a 0-indexed array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.

import java.util.ArrayList;
import java.util.List;

//
//You are also given a string s of length n, where s[i] is the character assigned to node i.
//
//Return the length of the longest path in the tree such that no pair of adjacent nodes on the path have the same character assigned to them.

public class LongestPathWithDifferentAdjacentCharacters {

	int max = 0;

	public int longestPath(int[] parent, String s) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < parent.length; i++) {
			adj.add(new ArrayList<>());
		}

		if (parent.length == 1)
			return 1;
		// create adjacency list
		for (int i = 1; i < parent.length; i++) {
			adj.get(i).add(parent[i]);
			adj.get(parent[i]).add(i);
		}

		dfs(adj, '#', 0, -1, s, false);
		return max;

	}

	int dfs(List<List<Integer>> adj, char ch, int node, int parent, String s, boolean flag) {

		int tempmax = 0, val = 0;
		// ls stores the path values returned by all the children of node
		// this will be useful to choose the maximum length path going from a node
		// through 2 of its children
		List<Integer> ls = new ArrayList<>();
		for (int child : adj.get(node)) {
			if (child == parent)
				continue;
			int temp;
			// if the current character is same as child's character, send flag as true;
			// this flag is useful to know whether the current path should be considered as
			// a path for parent or not
			if (s.charAt(child) == s.charAt(node))
				temp = dfs(adj, s.charAt(node), child, node, s, true);
			else
				temp = dfs(adj, s.charAt(node), child, node, s, false);
			ls.add(temp);
		}
		// we find the maximum and seconf maximum path lengths amongst all the children
		// for a given node
		// we will consider path only going through max and second max values
		int secmax = 0;
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i) > tempmax) {
				secmax = tempmax;
				tempmax = ls.get(i);
			} else if (ls.get(i) > secmax) {
				secmax = ls.get(i);
			}
		}
		// this will store the final result
		max = Math.max(max, tempmax + secmax + 1);

		if (flag) // we return 0 if flag true because, flag was set true by the parent when the
					// character of child and parent are same
			// so if the characters are same, we cannot consider any path going from child
			// as a part of greater path going through parent.
			// so by returning 0, we discard the possibility of parent considering the
			// child's path'
			return 0;
		// otherwise we return the max path seen till now through any of the children
		return 1 + tempmax;

	}

}
