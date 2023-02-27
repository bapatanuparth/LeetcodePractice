package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

//Given the root of a binary tree, return all root-to-leaf paths in any order.
//
//A leaf is a node with no children.
public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> out = new ArrayList<>();
		findPaths(root, out, "");
		return out;
	}

	void findPaths(TreeNode root, List<String> out, String s) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			s = s + root.val;
			out.add(s);
			return;
		}

		findPaths(root.left, out, s + root.val + "->");
		findPaths(root.right, out, s + root.val + "->");

		return;
	}
}
