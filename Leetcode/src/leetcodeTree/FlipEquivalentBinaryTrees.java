package leetcodeTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
//
//A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
//
//Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.

public class FlipEquivalentBinaryTrees {

	// better recursive approach
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null || root1.val != root2.val)
			return false;
		return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
				|| (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));
	}

	// approach using 2 maps
	public boolean flipEquiv2(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		Map<Integer, Set<Integer>> map1 = new HashMap<>();
		Map<Integer, Set<Integer>> map2 = new HashMap<>();
		flipCheck(root1, map1);
		flipCheck(root2, map2);

		return map1.equals(map2);
	}

	void flipCheck(TreeNode root1, Map<Integer, Set<Integer>> map1) {

		if (root1 != null) {
			map1.put(root1.val, new HashSet<>());
			if (root1.left != null && root1.right != null) {
				map1.get(root1.val).add(root1.left.val);
				map1.get(root1.val).add(root1.right.val);
			} else if (root1.left != null) {
				map1.get(root1.val).add(root1.left.val);
			} else if (root1.right != null) {
				map1.get(root1.val).add(root1.right.val);
			}
			flipCheck(root1.left, map1);
			flipCheck(root1.right, map1);
		}

	}

}
