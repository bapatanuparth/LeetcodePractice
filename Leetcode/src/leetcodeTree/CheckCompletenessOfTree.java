package leetcodeTree;

import java.util.ArrayDeque;
import java.util.Queue;

//Given the root of a binary tree, determine if it is a complete binary tree.
//
//In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

public class CheckCompletenessOfTree {

	// if u ever encounter a null child, u should not encounter any other element in
	// same level or in next level
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);

		boolean flag = false;
		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();

				if (node.left == null && node.right != null)
					return false;

				if (flag == true) {
					if (node.left != null || node.right != null)
						return false;
				} else {
					if (node.left == null || node.right == null)
						flag = true;
				}

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}
		return true;
	}

	// count all nodes in tree
	// check the concept we use for heap[ sort, for each element check if its left /
	// right child count goes out of total count of nodes
	public boolean isCompleteTreeDFS(TreeNode root) {
		int total = countNodes(root);
		return helper(root, 1, total);
	}

	private int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	// uses the property used in heapsort
	private boolean helper(TreeNode root, int idx, int total) {
		if (root == null) {
			return true;
		}
		if (idx > total) {
			return false;
		} // for each number, check if its left/right child is going over the total number
			// of elements in the tree
		return helper(root.left, idx * 2, total) && helper(root.right, idx * 2 + 1, total);
	}
}
