package leetcodeTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumIVBSTInput {

	// INORDER TRAVERSAL OF BST YEILDS SORTED ORDER
	public class Solution {
		public boolean findTarget(TreeNode root, int k) {
			List<Integer> list = new ArrayList();
			inorder(root, list); // store in-order traversal in sorted order and use 2 pointers on that
			int l = 0, r = list.size() - 1;
			while (l < r) {
				int sum = list.get(l) + list.get(r);
				if (sum == k)
					return true;
				if (sum < k)
					l++;
				else
					r--;
			}
			return false;
		}

		public void inorder(TreeNode root, List<Integer> list) {
			if (root == null)
				return;
			inorder(root.left, list);
			list.add(root.val);
			inorder(root.right, list);
		}
	}

	// same logic as array for two sum
	Set<Integer> set;

	public boolean findTarget(TreeNode root, int k) {
		set = new HashSet<>();
		return find(root, k);
	}

	boolean find(TreeNode root, int k) {
		if (root == null)
			return false;
		if (!set.isEmpty() && set.contains(root.val))
			return true;
		set.add(k - root.val);
		if (find(root.left, k))
			return true;
		if (find(root.right, k))
			return true;

		return false;
	}
}
