package leetcodeTree;

//Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
//
//A subtree of a node node is node plus every node that is a descendant of node.

public class BinaryTreePruning {

	public TreeNode pruneTree(TreeNode root) {
		return !prune(root) ? null : root;
	}

	boolean prune(TreeNode root) {
		if (root == null)
			return false;

		boolean left = prune(root.left);
		boolean right = prune(root.right);

		if (left == false)
			root.left = null;
		if (right == false)
			root.right = null;

		if (root.val == 0 && left == false && right == false)
			return false;
		return true;
	}
}
