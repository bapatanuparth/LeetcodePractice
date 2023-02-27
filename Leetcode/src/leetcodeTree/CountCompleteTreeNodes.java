package leetcodeTree;

//Given the root of a complete binary tree, return the number of the nodes in the tree.
//
//According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//
//Design an algorithm that runs in less than O(n) time complexity.

public class CountCompleteTreeNodes {

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		int left = getLeftHeight(root);
		int right = getRightHeight(root);

		if (left == right)
			return ((2 << (left)) - 1); // same as math.pow(2, h)

		else
			return countNodes(root.left) + countNodes(root.right) + 1;
	}

	int getLeftHeight(TreeNode root) {

		TreeNode temp = root;
		int level = 0;
		while (temp.left != null) {
			level++;
			temp = temp.left;
		}

		return level;
	}

	int getRightHeight(TreeNode root) {
		TreeNode temp = root;
		int level = 0;
		while (temp.right != null) {
			level++;
			temp = temp.right;
		}
		return level;
	}
}
