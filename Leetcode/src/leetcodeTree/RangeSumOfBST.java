package leetcodeTree;

public class RangeSumOfBST {
	int sum = 0;

	public int rangeSumBST(TreeNode root, int low, int high) {
		rangeHelper(root, low, high);
		return sum;

	}

	void rangeHelper(TreeNode root, int low, int high) {
		if (root == null)
			return;
		if (root.val < low) {
			rangeHelper(root.right, low, high);
			return;
		}
		if (root.val > high) {
			rangeHelper(root.left, low, high);
			return;
		}
		sum += root.val;
		rangeHelper(root.left, low, high);
		rangeHelper(root.right, low, high);
	}

}
