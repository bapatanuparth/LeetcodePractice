package leetcodeTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given the root of a binary tree, the depth of each node is the shortest distance to the root.
//
//Return the smallest subtree such that it contains all the deepest nodes in the original tree.
//
//A node is called the deepest if it has the largest depth possible among any node in the entire tree.
//
//The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.

public class SmallestSubtreeWithDeepestNodes {
	// we have to find lowest common ancestor of all the leaves

	// efficient single pass solution
//	public TreeNode subtreeWithAllDeepestEff(TreeNode root) {
//
//		return deep(root).getValue();
//	}
//
//	Pair<Integer, TreeNode> deep(TreeNode root) {
//		if (root == null)
//			return new Pair<>(0, null);
//
//		Pair<Integer, TreeNode> l = deep(root.left);
//		Pair<Integer, TreeNode> r = deep(root.right);
//
//		// left and right depth
//		int d1 = l.getKey();
//		int d2 = r.getKey();
//
//		// id d1==d2, then their lca must be root. if d1>d2, it means the left subtree
//		// has more height than right, hence we consider the root returned by left
//		// subtree as lca. otherwise consider root returned by right subtree as the lca
//		// of the maxDepth leaves on the right side.
//		return new Pair<>(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
//	}

	// my solution, requires multiple passes
	// basic strategy --> find out max height
	// find out leaves at that max height
	// find the lowest common ancestor amongst the leaves

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		List<TreeNode> leaves = new ArrayList<>();
		Map<TreeNode, Integer> map = new HashMap<>();
		int maxHeight = height(root, map, 1);
		for (TreeNode n : map.keySet()) {
			if (map.get(n) == maxHeight) {
				leaves.add(n);
			}
		}

		if (leaves.size() == 1)
			return leaves.get(0);

		TreeNode n1 = leaves.get(0);
		for (int i = 1; i < leaves.size(); i++) {
			TreeNode n2 = leaves.get(i);
			n1 = lca(root, n1, n2);
		}

		return n1;

	}

	// calculate max height and save the nodes with their height values in a map
	int height(TreeNode root, Map<TreeNode, Integer> map, int lev) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			map.put(root, lev);
		}
		return Math.max(height(root.left, map, lev + 1), height(root.right, map, lev + 1)) + 1;
	}

	// lowest common ancestor
	TreeNode lca(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null)
			return null;

		if (root.val == node1.val || root.val == node2.val)
			return root;

		TreeNode lca1 = lca(root.left, node1, node2);
		TreeNode lca2 = lca(root.right, node1, node2);

		if (lca1 != null && lca2 != null)
			return root;
		else if (lca1 != null)
			return lca1;
		else
			return lca2;
	}

}
