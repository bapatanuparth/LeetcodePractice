package leetcode150daysBTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> ls = new ArrayList<>();
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		if (root == null)
			return ls;

		q.add(root);
		while (!q.isEmpty()) {

			int size = q.size();
			TreeNode temp = null;

			for (int i = 0; i < size; i++) {
				temp = q.poll();
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
			ls.add(temp.val);
		}

		return ls;
	}

}
