package leetcode150daysBTree;

//A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
//
//The path sum of a path is the sum of the node's values in the path.
//
//Given the root of a binary tree, return the maximum path sum of any non-empty path.

public class BinaryTreeMaxPathSum {

	int maxSum;

	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		gainFromSubtree(root);
		return maxSum;
	}

	int gainFromSubtree(TreeNode root) {

		if (root == null)
			return 0;

		int left = Math.max(gainFromSubtree(root.left), 0);

		int right = Math.max(gainFromSubtree(root.right), 0);

		maxSum = Math.max(maxSum, root.val + left + right);

		return Math.max(left + root.val, right + root.val);

	}
}
