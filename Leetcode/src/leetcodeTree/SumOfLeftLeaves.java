package leetcodeTree;

public class SumOfLeftLeaves {

	int sum = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		getSum(root);
		return sum;
	}

	Integer getSum(TreeNode root) {
		if (root == null)
			return null;

		Integer left = getSum(root.left);
		Integer right = getSum(root.right);

		if (left == null && right == null)
			return root.val;
		if (left != null && left > Integer.MIN_VALUE)
			sum += left;
		return Integer.MIN_VALUE;
	}

}
