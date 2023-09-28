package leetcode150daysBST;

import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		inorder_left(root);
	}

	void inorder_left(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public int next() {
		TreeNode top = stack.pop();
		if (top.right != null) {
			inorder_left(top.right);
		}
		return top.val;
	}

	public boolean hasNext() {
		return stack.size() > 0;
	}

}
