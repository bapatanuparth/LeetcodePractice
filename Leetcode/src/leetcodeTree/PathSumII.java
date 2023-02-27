package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

//Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
//
//A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: [[5,4,11,2],[5,8,4,5]]

public class PathSumII {

	int count = 0;

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> out = new ArrayList<>();

		if (root == null)
			return out;
		hasPath(root, targetSum, temp, out, count);
		return out;
	}

	void hasPath(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> out, int count) {
		if (root == null)
			return;

		temp.add(root.val);

		if (targetSum == (count + root.val)) {
			if (root.left == null && root.right == null) {
				out.add(new ArrayList<>(temp));
				temp.remove(temp.size() - 1);
				return;
			}
		}

		hasPath(root.left, targetSum, temp, out, count + root.val);
		hasPath(root.right, targetSum, temp, out, count + root.val);

		temp.remove(temp.size() - 1);
		return;

	}

}
