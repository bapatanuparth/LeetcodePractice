package leetcode150daysBTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		Deque<TreeNode> ad = new ArrayDeque<>();

		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		ad.add(root);

		while (!ad.isEmpty()) {
			int size = ad.size();

			List<Integer> ls = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = ad.poll();
				if (curr.left != null)
					ad.add(curr.left);
				if (curr.right != null)
					ad.add(curr.right);
				ls.add(curr.val);
			}

			res.add(ls);
		}

		return res;
	}
}
