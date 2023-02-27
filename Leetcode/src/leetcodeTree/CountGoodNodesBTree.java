package leetcodeTree;
//Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

//

//Return the number of good nodes in the binary tree.

public class CountGoodNodesBTree {

	int max = 0;

	public int goodNodes(TreeNode root) {
		findGood(root, root.val);
		return max;
	}

	void findGood(TreeNode root, int val) {
		if (root == null)
			return;
		if (root.val >= val) {
			max++;
			findGood(root.left, root.val);
			findGood(root.right, root.val);
		} else {
			findGood(root.left, val);
			findGood(root.right, val);
		}
	}
}
