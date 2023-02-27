package leetcodeTree;

//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return check(root.left, root.right);
	}

	boolean check(TreeNode root1, TreeNode root2) {
		if (root1 == null)
			return root2 == null;
		else if (root2 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return check(root1.left, root2.right) && check(root1.right, root2.left);
	}
}
