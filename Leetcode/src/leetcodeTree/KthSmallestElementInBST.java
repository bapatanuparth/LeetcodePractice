package leetcodeTree;

public class KthSmallestElementInBST {

	class Level {
		int value;
	}

	int kthsmallest = 0;

	public int kthSmallest(TreeNode root, int k) {
		Level l = new Level();
		l.value = k;
		inOrder(root, l, k);
		return kthsmallest;
	}

	// inorder traversal, count k elements in order traversal
	void inOrder(TreeNode root, Level l, int k) {
		if (root == null)
			return;
		inOrder(root.left, l, k);
		l.value--;
		if (l.value == 0) {
			kthsmallest = root.val;
			return;
		}
		inOrder(root.right, l, k);

	}
}
