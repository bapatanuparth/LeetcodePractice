package leetcode150daysBTree;

public class CousinsInBTree {

	int x_level = -1, y_level = -1;
	boolean flag = true;

	public boolean isCousins(TreeNode root, int x, int y) {
		height(root, x, y, 0);
		return flag && x_level == y_level;
	}

	public int height(TreeNode root, int x, int y, int level) {
		if (root == null)
			return 0;
		if (root.val == x) {
			x_level = level;
			return 1;
		}
		if (root.val == y) {
			y_level = level;
			return 2;
		}
		int left = height(root.left, x, y, level + 1);
		int right = height(root.right, x, y, level + 1);

		if (left + right == 3)
			flag = false;

		return 0;
	}

}
