package leetcodeTree;

//Given a binary tree root and an integer target, delete all the leaf nodes with value target.
//
//Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you cannot).

public class DeleteLeavesWithGivenValue {
	public TreeNode removeLeafNodes(TreeNode root, int target) {
		if (root.left == null && root.right == null && root.val == target) {
			return null;
		}
		boolean bool = delete(root, target);
		return bool ? null : root;
	}

	boolean delete(TreeNode root, int target) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null && root.val == target) {
			return true;
		}
		boolean left = delete(root.left, target);
		boolean right = delete(root.right, target);
		if (left && right && root.val == target) {
			return true;
		}
		if (left) {
			root.left = null;
		}
		if (right) {
			root.right = null;
		}
		return false;
	}
}
