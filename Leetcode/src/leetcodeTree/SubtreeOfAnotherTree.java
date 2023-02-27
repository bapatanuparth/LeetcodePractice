package leetcodeTree;

//Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
//
//A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
public class SubtreeOfAnotherTree {

	// solution with single pass
	public boolean isSubtreeNew(TreeNode root, TreeNode subRoot) {
		return isSubtree(root, subRoot, false);
	}

	private boolean isSubtree(TreeNode root, TreeNode subRoot, boolean found) {
		if (root == null || subRoot == null) {
			return root == null && subRoot == null;
		}
		if (root.val == subRoot.val) {
			if (isSubtree(root.left, subRoot.left, true) && isSubtree(root.right, subRoot.right, true)) {
				return true;
			}
		}
		return !found && isSubtree(root.left, subRoot, false) || isSubtree(root.right, subRoot, false);
	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null)
			return false;

		if (root.val == subRoot.val) // we can have tree nodes with duplicate values
		{
			if (isSame(root, subRoot) == true)
				return true; // return true only if we found the same tree
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); // else check further if there is a
																				// different node that
		// is equal to the subtree
	}

	boolean isSame(TreeNode root, TreeNode subRoot) { // code to check whether two trees are same
		if (root == null && subRoot == null)
			return true;

		if (root != null && subRoot != null) {
			if (root.val != subRoot.val)
				return false;
			else {
				boolean left = isSame(root.left, subRoot.left);
				return left && isSame(root.right, subRoot.right); // if left and right children are same, return true
			}
		} else
			return false;
	}
}
