package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

//Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
//
//If the tree has more than one mode, return them in any order.
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than or equal to the node's key.
//The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
//Both the left and right subtrees must also be binary search trees.

public class FindModeInBST {

	Integer prev = null;
	int max = 0;
	int count = 1;

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
