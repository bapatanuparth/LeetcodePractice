package leetcodeTree;

public class MinAbsoluteDiffInBST {

	// to check difference we need immediate predecessor in the inorder traversal
	// we keep it in prev

	int min = Integer.MAX_VALUE;
	TreeNode prev = null;

	public int getMinimumDifference(TreeNode root) {
		inorder(root);
		return min;
	}

	void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev != null)
			min = Math.min(min, root.val - prev.val);
		prev = root;
		inorder(root.right);

	}

}
