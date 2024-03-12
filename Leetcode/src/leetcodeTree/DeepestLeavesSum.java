package leetcodeTree;

import java.util.ArrayDeque;
import java.util.Queue;

//Given the root of a binary tree, return the sum of values of its deepest leaves.

public class DeepestLeavesSum {
	public int deepestLeavesSum(TreeNode root) {

		int sum = 0;
		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int s = q.size();
			sum = 0;
			while (s > 0) {
				TreeNode curr = q.poll();
				sum += curr.val;
				if (curr.left != null)
					q.offer(curr.left);
				if (curr.right != null)
					q.offer(curr.right);
				s--;
			}
		}

		return sum;
	}

}
