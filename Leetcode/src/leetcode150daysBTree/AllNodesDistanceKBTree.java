package leetcode150daysBTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
//
//You can return the answer in any order.

public class AllNodesDistanceKBTree {

	Map<TreeNode, TreeNode> backEdge;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		backEdge = new HashMap<>();
		Set<TreeNode> visited = new HashSet<>();
		List<Integer> res = new ArrayList<>();
		dfs(root, target);
		// System.out.println(backEdge);
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
