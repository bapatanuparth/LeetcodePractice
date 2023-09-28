package leetcode150daysBTree;

//Given the root of a binary tree, flatten the tree into a "linked list":
//
//The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.

public class FlattenBTreeToLL {

	// we are building linked list from bottom to top
	TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode node = root;
		while (node != null) {
			if (node.left != null) {
				TreeNode rightmost = node.left;
				while (rightmost.right != null)
					rightmost = rightmost.right;

				rightmost.right = node.right;
				node.right = node.left;
				node.left = null;
			}
			node = node.right;
		}
	}
}
