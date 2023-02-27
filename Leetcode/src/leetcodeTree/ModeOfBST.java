package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

public class ModeOfBST {

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {

		Integer prev = null;
		int max = 0;
		int count = 1;

		// mode of BST without using map
		public int[] findMode(TreeNode root) {
			if (root == null)
				return new int[0];

			List<Integer> list = new ArrayList<>();
			traverse(list, root);

			int[] res = new int[list.size()];
			for (int i = 0; i < list.size(); ++i)
				res[i] = list.get(i);
			return res;

		}

		void traverse(List<Integer> ls, TreeNode root) {
			if (root == null)
				return;
			traverse(ls, root.left);
			if (prev != null) {
				if (prev == root.val)
					count++;
				else
					count = 1;
			}
			if (count > max) {
				max = count;
				ls.clear();
				ls.add(root.val);
			} else if (count == max) {
				ls.add(root.val);
			}
			prev = root.val;
			traverse(ls, root.right);
		}
	}
}
