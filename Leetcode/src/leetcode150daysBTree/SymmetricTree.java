package leetcode150daysBTree;

//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return (check(root.left, root.right));
	}

	boolean check(TreeNode left, TreeNode right) {
		if (left == null)
			return right == null;
		if (right == null)
			return left == null;
		if (left.val != right.val)
			return false;
		if (!check(left.left, right.right))
			return false;
		if (!check(left.right, right.left))
			return false;

		return true;
	}

}
