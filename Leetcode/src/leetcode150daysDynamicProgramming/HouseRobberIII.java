package leetcode150daysDynamicProgramming;

public class HouseRobberIII {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Amount {
		int curr; // we store max value till the curr node(max(both children , curr))
		int child; // we store both children values here

		Amount(int c, int ch) {
			this.curr = c;
			this.child = ch;
		}

	} // idea is to pass 2 values, the current value, and current's children value to
		// the parent so that we can simulate dp like in array

	public int rob(TreeNode root) {
		Amount a = robHouse(root);
		return Math.max(a.curr, a.child);
	}

	Amount robHouse(TreeNode root) {
		if (root == null)
			return new Amount(0, 0);

		Amount left = robHouse(root.left); // get max from left child
		Amount right = robHouse(root.right); // get max from right child

		int maxCurr = root.val + left.child + right.child; // maxCurr considering grandchildren so that we dont take
															// adjacent nodes
		int dpCurr = Math.max(left.curr + right.curr, maxCurr); // current can be either == sum of both children || the
																// current value considering grandchildren according to
																// DP
		return new Amount(dpCurr, left.curr + right.curr); // we pass it as dp of current value, or the children of
															// current that will be used by parent

	}
}
