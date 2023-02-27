package leetcodeTree;
//Given the root of a binary tree and an array of TreeNode objects nodes, return the lowest common ancestor (LCA) of all the nodes in nodes. All the nodes will exist in the tree, and all values of the tree's nodes are unique.

//
//Extending the definition of LCA on Wikipedia: "The lowest common ancestor of n nodes p1, p2, ..., pn in a binary tree T is the lowest node that has every pi as a descendant (where we allow a node to be a descendant of itself) for every valid i". A descendant of a node x is a node y that is on the path from node x to some leaf node.

public class LowestCommonAncestorIV {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
		if (nodes.length == 0)
			return null;
		if (nodes.length == 1)
			return nodes[0];
		TreeNode n1 = nodes[0];

		// iterate over all the nodes
		for (int i = 1; i < nodes.length; i++) {
			TreeNode n2 = nodes[i];

			n1 = lca(root, n1, n2);
		}

		return n1;
	}

	// code to calculate lca of 2 nodes
	TreeNode lca(TreeNode root, TreeNode node1, TreeNode node2) {
		if (root == null)
			return null;
		if (root.val == node1.val || root.val == node2.val)
			return root;
		TreeNode lca1 = lca(root.left, node1, node2);
		TreeNode lca2 = lca(root.right, node1, node2);

		if (lca1 != null && lca2 != null)
			return root;
		if (lca1 != null)
			return lca1;
		else
			return lca2;
	}
}
