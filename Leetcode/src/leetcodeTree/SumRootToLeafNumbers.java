package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

//You are given the root of a binary tree containing digits from 0 to 9 only.
//
//Each root-to-leaf path in the tree represents a number.
//
//For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
//
//A leaf node is a node with no children.

public class SumRootToLeafNumbers {

	// simple preorder traversal
	int rootToLeaf = 0;

	public void preorder(TreeNode r, int currNumber) {
		if (r != null) {
			currNumber = currNumber * 10 + r.val;
			// if it's a leaf, update root-to-leaf sum
			if (r.left == null && r.right == null) {
				rootToLeaf += currNumber;
			}
			preorder(r.left, currNumber);
			preorder(r.right, currNumber);
		}
	}

	public int sumNumbers(TreeNode root) {
		preorder(root, 0);
		return rootToLeaf;
	}

	// using string and preorder traversal
	class Solution {
		List<String> ls;

		class Wrap {
			int num;
		}

		public int sumNumbers(TreeNode root) {
			ls = new ArrayList<>();
			Wrap prev = new Wrap();
			prev.num = 0;
			build(root, new StringBuilder(), prev);
			return prev.num;
		}

		int build(TreeNode root, StringBuilder sb, Wrap prev) {
			if (root == null)
				return -1;
			sb.append(root.val);
			if (root.left == null && root.right == null) {
				int val = Integer.parseInt(sb.toString());
				prev.num += val;
				return 0;
			}
			if (build(root.left, sb, prev) != -1)
				sb.deleteCharAt(sb.length() - 1);

			if (build(root.right, sb, prev) != -1)
				sb.deleteCharAt(sb.length() - 1);

			return 0;
		}

	}

}
