package leetcode150daysBST;

//Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

public class LCAofBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// Value of current node or parent node.
		int parentVal = root.val;

		// Value of p
		int pVal = p.val;

		// Value of q;
		int qVal = q.val;

		if (pVal > parentVal && qVal > parentVal) {
			// If both p and q are greater than parent
			return lowestCommonAncestor(root.right, p, q);
		} else if (pVal < parentVal && qVal < parentVal) {
			// If both p and q are lesser than parent
			return lowestCommonAncestor(root.left, p, q);
		} else {
			// We have found the split point, i.e. the LCA node.
			return root;
		}
	}

}
