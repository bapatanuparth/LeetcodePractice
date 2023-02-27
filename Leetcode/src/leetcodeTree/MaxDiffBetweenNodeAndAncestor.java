package leetcodeTree;

//Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

//
//A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

public class MaxDiffBetweenNodeAndAncestor {

	// efficient solution
	public int maxAncestorDiff(TreeNode root) {
		if (root == null)
			return 0;
		return dfs(root, root.val, root.val);
	}

	// keep a track of running max and min from root to the leaf. max difference
	// between node and ancestor will be max - min from root to leaf
	public int dfs(TreeNode root, int min, int max) {
		if (root == null)
			return max - min;
		max = Math.max(max, root.val);
		min = Math.min(min, root.val);
		int left = dfs(root.left, min, max);
		int right = dfs(root.right, min, max);
		return Math.max(left, right);
	}
}
