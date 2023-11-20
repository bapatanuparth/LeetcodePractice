package leetcodeTree;

//Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.
//
//Note:
//
//The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
//A subtree of root is a tree consisting of root and all of its descendants.

public class CountNodesEqualToAverageSubtree {

	class Average {
		int val;
		int nodes;

		public Average(int val, int n) {
			this.val = val;
			this.nodes = n;
		}
	}

	class Solution {
		int max = 0;

		public int averageOfSubtree(TreeNode root) {
			sum(root);
			return max;
		}

		Average sum(TreeNode root) {
			if (root == null)
				return new Average(0, 0);
			Average left = sum(root.left);
			Average right = sum(root.right);

			int n = left.nodes + right.nodes + 1;
			int sum = left.val + right.val + root.val;
			int avg = sum / n;
			if (avg == root.val) {
				max++;
			}
			return new Average(sum, n);
		}
	}

}
