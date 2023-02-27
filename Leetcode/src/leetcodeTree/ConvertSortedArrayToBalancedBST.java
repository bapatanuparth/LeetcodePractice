package leetcodeTree;

public class ConvertSortedArrayToBalancedBST {

	// divide array in half and recursively call to create tree
	public TreeNode sortedArrayToBST(int[] nums) {
		int mid = nums.length / 2;
		int left = 0, right = nums.length - 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = convert(root, nums, left, mid - 1);
		root.right = convert(root, nums, mid + 1, right);
		return root;
	}

	TreeNode convert(TreeNode root, int nums[], int left, int right) {
		if (left > right)
			return null;
		int mid = left + (right - left) / 2;
		TreeNode newnode = new TreeNode(nums[mid]);
		newnode.left = convert(newnode, nums, left, mid - 1);
		newnode.right = convert(newnode, nums, mid + 1, right);
		return newnode;
	}

}
