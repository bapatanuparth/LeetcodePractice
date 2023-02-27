package leetcodeTree;

import java.util.ArrayDeque;
import java.util.Queue;

//Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
//
//Note that the root node is at depth 1.
//
//The adding rule is:
//
//Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
//cur's original left subtree should be the left subtree of the new left subtree root.
//cur's original right subtree should be the right subtree of the new right subtree root.
//If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
public class AddOneRowToTree {

	public TreeNode addOneRow(TreeNode root, int val, int depth) {

		if (depth == 1) {
			TreeNode newnode = new TreeNode(val);
			newnode.left = root;
			return newnode;

		}

		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		int level = 1;

		while (!q.isEmpty()) {

			int size = q.size();

			if (level == (depth - 1)) {

				for (int i = 0; i < size; i++) {
					TreeNode curr = q.poll();

					TreeNode newleft = new TreeNode(val);
					newleft.left = curr.left;
					curr.left = newleft;

					TreeNode newnode = new TreeNode(val);
					newnode.right = curr.right;
					curr.right = newnode;
				}
				return root;

			}

			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();

				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}

			level++;
		}

		return root;
	}
}
