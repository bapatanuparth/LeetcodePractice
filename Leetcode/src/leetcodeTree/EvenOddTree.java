package leetcodeTree;

import java.util.ArrayDeque;
import java.util.Queue;

//A binary tree is named Even-Odd if it meets the following conditions:
//
//The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
//For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
//For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
//Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

public class EvenOddTree {

	public boolean isEvenOddTree(TreeNode root) {
		if (root.val % 2 == 0)
			return false;

		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);

		boolean level = false; // 0 2 4 6
		while (!q.isEmpty()) {

			int s = q.size();
			int prev = -1;
			for (int i = 0; i < s; i++) {
				TreeNode node = q.poll();
				if (prev != -1 && !level && (node.val <= prev))
					return false;
				if (prev != -1 && level && (node.val >= prev))
					return false;

				prev = node.val;

				if (!level) {
					if (node.val % 2 == 0)
						return false;
					if (node.left != null)
						q.add(node.left);
					if (node.right != null)
						q.add(node.right);
				} else {
					if (node.val % 2 != 0)
						return false;
					if (node.left != null)
						q.add(node.left);
					if (node.right != null)
						q.add(node.right);
				}

			}
			level = !level;
		}

		return true;
	}

}
