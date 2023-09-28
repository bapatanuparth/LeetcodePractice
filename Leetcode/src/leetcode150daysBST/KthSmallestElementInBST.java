package leetcode150daysBST;

//Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

public class KthSmallestElementInBST {

	int kthSmallest = 0;

	class Level {
		int lev;

		Level(int l) {
			this.lev = l;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		Level count = new Level(0);
		calcValue(root, k, count);
		return kthSmallest;
	}

	void calcValue(TreeNode root, int k, Level count) {
		if (root == null)
			return;
		calcValue(root.left, k, count);
		count.lev = count.lev + 1;
		if (count.lev == k) {
			kthSmallest = root.val;
			return;
		}
		calcValue(root.right, k, count);
	}

}
