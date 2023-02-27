package leetcodeTree;

//Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

//
//A leaf is a node with no children.

public class PathSum {

	int count = 0;

	public boolean hasPathSum(TreeNode root, int targetSum) {

		if (root == null)
			return false;

		return hasPat(root, targetSum, count);

	}

	// go adding on each node, if sum == target sum, check if its leaf node
	// DFS approach recursively call
	public boolean hasPat(TreeNode root, int targetSum, int count) {

		if (root == null)
			return false;

		if (targetSum == (count + root.val)) {
			if (root.left == null && root.right == null)
				return true;
		}

		if (hasPat(root.left, targetSum, count + root.val))
			return true;
		if (hasPat(root.right, targetSum, count + root.val))
			return true;
		return false;
	}
}
