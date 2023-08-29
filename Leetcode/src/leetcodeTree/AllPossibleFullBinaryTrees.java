package leetcodeTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.
//
//Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.
//
//A full binary tree is a binary tree where each node has exactly 0 or 2 children.

public class AllPossibleFullBinaryTrees {

	private Map<Integer, List<TreeNode>> memo = new HashMap<>();

	public List<TreeNode> allPossibleFBT(int n) {
		if (n % 2 == 0) {
			return new ArrayList<TreeNode>();
		}

		if (n == 1) {
			return Arrays.asList(new TreeNode());
		}

		if (memo.containsKey(n)) {
			return memo.get(n);
		}

		List<TreeNode> res = new ArrayList<TreeNode>();
		for (int i = 1; i < n; i += 2) {
			List<TreeNode> left = allPossibleFBT(i);
			List<TreeNode> right = allPossibleFBT(n - i - 1);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(0, l, r);
					res.add(root);
				}
			}
		}

		memo.put(n, res);
		return res;
	}

}
