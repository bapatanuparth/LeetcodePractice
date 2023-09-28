package leetcode150daysBTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		q.add(root);

		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();

			LinkedList<Integer> ls = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode temp = q.poll();

				if (temp.left != null)
					q.add(temp.left);

				if (temp.right != null)
					q.add(temp.right);

				if (level % 2 == 0) {
					ls.add(temp.val);
				} else
					ls.addFirst(temp.val);
			}
			res.add(ls);
			level++;
		}

		return res;

	}

}
