package leetcode150daysBTree;

//You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.
//
//In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.
//
//Return the minimum number of moves required to make every node have exactly one coin.

public class DistributeCoins {

	int moves = 0;

	public int distributeCoins(TreeNode root) {
		postOrder(root, null);
		return moves;
	}

	void postOrder(TreeNode root, TreeNode parent) {
		if (root == null)
			return;
		postOrder(root.left, root);
		postOrder(root.right, root);

		if (root.val > 1) {
			moves += root.val - 1;
			parent.val += root.val - 1;
		} else if (root.val < 1) {
			moves += (1 - root.val);
			parent.val -= (1 - root.val);
		}
	}

}
