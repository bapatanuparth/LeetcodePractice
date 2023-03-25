package leetcodeTree;

//Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.
//
//Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.

public class ConstructStringFromBinaryTree {

	public String tree2str(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		sb.append(root.val);
		if (root.left == null && root.right != null)
			sb.append("()");
		create(root.left, sb);
		create(root.right, sb);

		return sb.toString();
	}

	void create(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;

		sb.append("(");
		sb.append(root.val);
		if (root.left == null && root.right != null)
			sb.append("()");
		create(root.left, sb);
		create(root.right, sb);
		sb.append(")");
	}
}
