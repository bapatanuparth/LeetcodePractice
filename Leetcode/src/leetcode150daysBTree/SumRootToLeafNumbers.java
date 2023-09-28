package leetcode150daysBTree;

//You are given the root of a binary tree containing digits from 0 to 9 only.
//
//Each root-to-leaf path in the tree represents a number.
//
//For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
//
//A leaf node is a node with no children.

public class SumRootToLeafNumbers {

	int rootToLeaf = 0;

	public void preorder(TreeNode r, int currNumber) {
		if (r != null) {
			currNumber = currNumber * 10 + r.val;
			// if it's a leaf, update root-to-leaf sum
			if (r.left == null && r.right == null) {
				rootToLeaf += currNumber;
			}
			preorder(r.left, currNumber);
			preorder(r.right, currNumber);
		}
	}

	public int sumNumbers(TreeNode root) {
		preorder(root, 0);
		return rootToLeaf;
	}

}
