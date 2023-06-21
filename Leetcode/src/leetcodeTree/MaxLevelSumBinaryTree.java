package leetcodeTree;

import java.util.ArrayDeque;
import java.util.Queue;

//Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
//
//Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

public class MaxLevelSumBinaryTree {

	public int maxLevelSum(TreeNode root) {

		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		int maxLevel = 0;
		int maxSum = Integer.MIN_VALUE;
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			int sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode poll = q.poll();
				sum += poll.val;
				if (poll.left != null)
					q.add(poll.left);
				if (poll.right != null)
					q.add(poll.right);
			}
			level++;
			if (sum > maxSum) {
				maxSum = sum;
				maxLevel = level;
			}
		}

		return maxLevel;
	}

}
