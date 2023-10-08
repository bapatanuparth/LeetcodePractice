package leetcode150daysDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<TreeNode> generateTrees(int n) {
		return allBST(1, n);
	}

	List<TreeNode> allBST(int start, int end) {
		List<TreeNode> all = new ArrayList<>();
		if (start == end) {
			TreeNode root = new TreeNode(start);
			all.add(root);
			return all;
		}
		if (start > end) {
			all.add(null);
			return all;
		}

		for (int root = start; root <= end; root++) {
			List<TreeNode> left = allBST(start, root - 1);
			List<TreeNode> right = allBST(root + 1, end);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode rootNode = new TreeNode(root);
					rootNode.left = l;
					rootNode.right = r;
					all.add(rootNode);
				}
			}
		}

		return all;

	}

}
