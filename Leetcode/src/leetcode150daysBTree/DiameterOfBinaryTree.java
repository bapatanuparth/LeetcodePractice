package leetcode150daysBTree;

//Given the root of a binary tree, return the length of the diameter of the tree.
//
//The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
//The length of a path between two nodes is represented by the number of edges between them.

public class DiameterOfBinaryTree {

	int res = 0;

	public int diameterOfBinaryTree(TreeNode root) {

		calcDia(root);
		return res;
	}

	int calcDia(TreeNode root) {
		if (root == null)
			return 0;
		int lh = calcDia(root.left);
		int rh = calcDia(root.right);
		res = Math.max(lh + rh, res);
		return Math.max(lh, rh) + 1;
	}

}