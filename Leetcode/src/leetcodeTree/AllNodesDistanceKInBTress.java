package leetcodeTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

//	DFS to build the back edges ( backEdge[child] = parent )
//	BFS from the target as a center until the distance acheives K.

	Map<TreeNode, TreeNode> backEdge;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		backEdge = new HashMap<>();
		Set<TreeNode> visited = new HashSet<>();
		List<Integer> res = new ArrayList<>();
		dfs(root, target);

		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(target);

		while (!q.isEmpty() && k >= 0) {
			int s = q.size();
			while (s > 0) {
				TreeNode cur = q.poll();
				visited.add(cur);
				if (k == 0)
					res.add(cur.val);
				if (backEdge.containsKey(cur) && !visited.contains(backEdge.get(cur)))
					q.offer(backEdge.get(cur));
				if (cur.left != null && !visited.contains(cur.left))
					q.offer(cur.left);
				if (cur.right != null && !visited.contains(cur.right))
					q.offer(cur.right);
				s--;
			}
			k--;
		}

		return res;
	}

	void dfs(TreeNode root, TreeNode target) {
		if (root == null || root == target)
			return;
		if (root.left != null) {
			backEdge.put(root.left, root);
		}
		if (root.right != null)
			backEdge.put(root.right, root);
		dfs(root.left, target);
		dfs(root.right, target);
	}

}

public class AllNodesDistanceKInBTress {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

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
