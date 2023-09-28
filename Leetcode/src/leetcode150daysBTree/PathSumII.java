package leetcode150daysBTree;

import java.util.ArrayList;
import java.util.List;

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
