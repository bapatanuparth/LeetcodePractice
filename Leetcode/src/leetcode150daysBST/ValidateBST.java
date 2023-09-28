package leetcode150daysBST;

import java.util.ArrayList;
import java.util.List;

//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//
//A valid BST is defined as follows:
//
//The left 
//subtree
// of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.

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

public class ValidateBST {

	public boolean isValidBST(TreeNode root) {
		List<Integer> ls = new ArrayList<>();
		return checkBST(root, ls);
	}

	boolean checkBST(TreeNode root, List<Integer> list) {
		if (root == null)
			return true;
		boolean left = checkBST(root.left, list);
		if (!list.isEmpty()) {
			if (list.get(list.size() - 1) >= root.val)
				return false;
		}
		list.add(root.val);
		return left && checkBST(root.right, list);
	}

}
