package leetcode150daysBTree;

//Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
//
//A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

public class SubtreeOfAnotherTree {

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		return isSubtree(root, subRoot, false);
	}

	boolean isSubtree(TreeNode root, TreeNode subRoot, boolean found) {
		if (root == null || subRoot == null)
			return root == null && subRoot == null;
		if (root.val == subRoot.val) {
			if (isSubtree(root.left, subRoot.left, true) && isSubtree(root.right, subRoot.right, true))
				return true;
		}

		return !found && isSubtree(root.left, subRoot, false) || isSubtree(root.right, subRoot, false);
	}

}
