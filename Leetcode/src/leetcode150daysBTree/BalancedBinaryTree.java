package leetcode150daysBTree;

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		return calcHeight(root) != -1;
	}

	int calcHeight(TreeNode root) {
		if (root == null)
			return 0;
		int lh = calcHeight(root.left);
		int rh = calcHeight(root.right);
		if (lh == -1 || rh == -1)
			return -1;
		if (Math.abs(lh - rh) > 1)
			return -1;
		return Math.max(lh, rh) + 1;
	}

}
