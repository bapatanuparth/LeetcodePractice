package leetcode150daysBST;

import java.util.ArrayList;
import java.util.List;

//Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
//
//A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

public class BalanceBST {

	class Solution {
		List<TreeNode> sortedArr = new ArrayList<>();

		public TreeNode balanceBST(TreeNode root) {
			inorderTraverse(root);
			return sortedArrayToBST(0, sortedArr.size() - 1);
		}

		void inorderTraverse(TreeNode root) {
			if (root == null)
				return;
			inorderTraverse(root.left);
			sortedArr.add(root);
			inorderTraverse(root.right);
		}

		TreeNode sortedArrayToBST(int start, int end) {
			if (start > end)
				return null;
			int mid = (start + end) / 2;
			TreeNode root = sortedArr.get(mid);
			root.left = sortedArrayToBST(start, mid - 1);
			root.right = sortedArrayToBST(mid + 1, end);
			return root;
		}
	}

}
