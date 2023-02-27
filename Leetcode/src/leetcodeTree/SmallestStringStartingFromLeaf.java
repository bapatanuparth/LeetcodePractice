package leetcodeTree;

import java.util.PriorityQueue;
import java.util.Queue;

//You are given the root of a binary tree where each node has a value in the range [0, 25] representing the letters 'a' to 'z'.
//
//Return the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
//
//As a reminder, any shorter prefix of a string is lexicographically smaller.
//
//For example, "ab" is lexicographically smaller than "aba".
//A leaf of a node is a node that has no children.
public class SmallestStringStartingFromLeaf {

	public String smallestFromLeaf(TreeNode root) {

		// use heap to get the smallest string
		Queue<String> q = new PriorityQueue<>((a, b) -> a.compareTo(b));
		traverse(root, q, "");
		return q.poll();
	}

	void traverse(TreeNode root, Queue<String> q, String s) {
		if (root == null)
			return;

		char ch = (char) ('a' + root.val);
		s += ch;
		traverse(root.left, q, s);
		traverse(root.right, q, s);
		if (root.left == null && root.right == null) {
			StringBuilder sb = new StringBuilder(s);
			sb.reverse();
			q.add(sb.toString());
		}
	}
}
