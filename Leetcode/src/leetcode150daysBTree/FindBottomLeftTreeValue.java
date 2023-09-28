package leetcode150daysBTree;

import java.util.ArrayDeque;
import java.util.Deque;

//Given the root of a binary tree, return the leftmost value in the last row of the tree.

public class FindBottomLeftTreeValue {

	public int findBottomLeftValue(TreeNode root) {
		Deque<TreeNode> dq = new ArrayDeque<>();
		dq.offerLast(root);
		int potential = 0;

		while (!dq.isEmpty()) {
			int s = dq.size();
			potential = dq.peekFirst().val;
			while (s > 0) {
				TreeNode node = dq.pollFirst();
				if (node.left != null)
					dq.offerLast(node.left);
				if (node.right != null)
					dq.offerLast(node.right);
				s--;
			}
		}

		return potential;
	}

}
