package leetcodeTree;

public class MaxSumBSTInBinaryTree {

	int maxsum = Integer.MIN_VALUE;

	public int maxSumBST(TreeNode root) {
		checkBST(root);
		if (maxsum < 0)
			return 0;
		return maxsum;
	}

	// [min value till now in subtree, max value till now in subtree, sum till now
	// in subtree]
	int[] checkBST(TreeNode root) {
		if (root == null)
			return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
		// Post order traversal
		int[] left = checkBST(root.left);
		int[] right = checkBST(root.right);

		// here we have 2 arrays in left and right if they both are BSTs
		if (!(left != null && // left and right subtree must be BST
				right != null && // must be BST
				root.val > left[1] && // check BST conditions
				root.val < right[0]))
			return null; // return null if current subtree at root is not a BST
		// calculate new sum with current value
		int sum = left[2] + right[2] + root.val;
		maxsum = Math.max(maxsum, sum);
		// valvulate smallest amongst all the elements from LHS and root
		int min = Math.min(root.val, left[0]);
		// calculate the largest amongst all the element on RHS
		int max = Math.max(root.val, right[1]);

		return new int[] { min, max, sum };
	}

}
