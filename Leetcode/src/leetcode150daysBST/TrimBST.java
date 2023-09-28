package leetcode150daysBST;

//Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.
//
//Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

public class TrimBST {

	// post order traversal
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null)
			return null;

		TreeNode left = trimBST(root.left, low, high);
		TreeNode right = trimBST(root.right, low, high);
		// if root.val < low, we send root.right to the parent, because any val on left
		// is going to be lower
		if (root.val < low) {
			return right;
		}
		// if root.val > high, we send root.left back to the parent
		else if (root.val > high)
			return left;
		// attach left and right
		root.left = left;
		root.right = right;
		return root;
	}

}
