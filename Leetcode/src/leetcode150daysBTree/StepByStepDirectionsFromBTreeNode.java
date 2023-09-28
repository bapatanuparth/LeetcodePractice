package leetcode150daysBTree;

//You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

//
//Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
//
//'L' means to go from a node to its left child node.
//'R' means to go from a node to its right child node.
//'U' means to go from a node to its parent node.
//Return the step-by-step directions of the shortest path from node s to node t.

public class StepByStepDirectionsFromBTreeNode {
//	The shortest path between any two nodes in a tree must pass through their Lowest Common Ancestor (LCA). The path will travel upwards from node s to the LCA and then downwards from the LCA to node t.
//	Find the path strings from root → s, and root → t. Can you use these two strings to prepare the final answer?
//	Remove the longest common prefix of the two path strings to get the path LCA → s, and LCA → t. Each step in the path of LCA → s should be reversed as 'U'.

	public String getDirections(TreeNode root, int startValue, int destValue) {
		StringBuilder s = new StringBuilder();
		StringBuilder d = new StringBuilder();
		find(root, startValue, s);
		find(root, destValue, d);
		int max_i = Math.min(s.length(), d.length());
		int i = 0;
		while (i < max_i && s.charAt(s.length() - 1 - i) == d.charAt(d.length() - 1 - i))
			i++;
		return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
	}

	boolean find(TreeNode root, int val, StringBuilder sb) {
		if (root.val == val)
			return true;
		if (root.left != null && find(root.left, val, sb))
			sb.append("L");
		else if (root.right != null && find(root.right, val, sb))
			sb.append("R");
		return sb.length() > 0;
	}
}
