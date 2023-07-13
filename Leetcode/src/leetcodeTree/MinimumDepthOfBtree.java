package leetcodeTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBtree {

	// to check if passed value is empty
	boolean temp = false;

	public int minDepth(TreeNode root) {
		if (root == null) {
			// if tree is empty, return 0 else return integer. max_value
			if (!temp)
				return 0;
			return Integer.MAX_VALUE;
		}
		temp = true;

		if (root.left == null && root.right == null) {
			return 1;
		} else
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public int minDepthBFS(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int depth = 1;

		while (q.isEmpty() == false) {
			int qSize = q.size();

			while (qSize > 0) {
				qSize--;

				TreeNode node = q.remove();
				// Since we added nodes without checking null, we need to skip them here.
				if (node == null) {
					continue;
				}

				// The first leaf would be at minimum depth, hence return it.
				if (node.left == null && node.right == null) {
					return depth;
				}

				q.add(node.left);
				q.add(node.right);
			}
			depth++;
		}
		return -1;
	}
}
