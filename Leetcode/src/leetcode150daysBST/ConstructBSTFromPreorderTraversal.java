package leetcode150daysBST;

//Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.
//
//It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.
//
//A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.
//
//A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

public class ConstructBSTFromPreorderTraversal {

	public TreeNode bstFromPreorder(int[] preorder) {
		return construct(preorder, 0, preorder.length - 1);
	}

	TreeNode construct(int[] preorder, int start, int end) {
		if (start > end)
			return null;
		TreeNode root = new TreeNode(preorder[start]);
		int m = findMid(preorder, start, end);
		root.left = construct(preorder, start + 1, m - 1);
		root.right = construct(preorder, m, end);
		return root;
	}

	int findMid(int[] preorder, int start, int end) {
		int left = start + 1, right = end;
		int ans = end + 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (preorder[mid] > preorder[start]) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return ans;
	}

}
