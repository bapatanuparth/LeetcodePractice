package leetcode150daysBTree;

//Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
//
//Basically, the deletion can be divided into two stages:
//
//Search for a node to remove.
//If the node is found, delete the node.

public class DeleteNodeBTree {

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				TreeNode succ = getSuccessor(root.right);
				root.val = succ.val;
				root.right = deleteNode(root.right, succ.val);
			}
		}
		return root;
	}

	TreeNode getSuccessor(TreeNode root) {
		if (root.left == null)
			return root;
		return getSuccessor(root.left);
	}
}
