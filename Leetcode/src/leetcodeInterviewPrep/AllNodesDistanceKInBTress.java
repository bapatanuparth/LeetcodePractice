package leetcodeInterviewPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class AllNodesDistanceKInBTress {

	// use a map to store all the ancestors of target with their distance from
	// target
	// then while doing dfs, if an ancestor is seen, check which level the ancestor
	// is on, if level == k add to res
	// then while making next calls pass level+1
	// if next element is also an ancestor, the value will be updated by that mapped
	// value
	// if next is not an ancestor, the value will be == level+1 which we desire

	Map<TreeNode, Integer> map;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		map = new HashMap<>();
		List<Integer> res = new ArrayList<>();
		find(root, target, k);
		dfs(root, k, 0, res);
		return res;

	}

	// find the ancestors and their distance from the target node
	int find(TreeNode root, TreeNode target, int k) {
		if (root == null)
			return -1;

		if (root.val == target.val) {
			map.put(root, 0);
			return 0;
		}

		int left = find(root.left, target, k);
		if (left >= 0) {
			map.put(root, left + 1);
			return ++left;
		}

		int right = find(root.right, target, k);
		if (right >= 0) {
			map.put(root, ++right);
			return right;
		}

		return -1;
	}

	void dfs(TreeNode root, int k, int level, List<Integer> res) {
		if (root == null)
			return;
		// this means root is ancestor, use the level from map as this is the distance
		// of ancestor from the target node
		if (map.containsKey(root))
			level = map.get(root);
		if (level == k)
			res.add(root.val);
		dfs(root.left, k, level + 1, res);
		dfs(root.right, k, level + 1, res);
	}
}
