package leetcode150daysBTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		return dfs(root);
	}

	TreeNode dfs(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = dfs(root.left);
		TreeNode right = dfs(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

}
