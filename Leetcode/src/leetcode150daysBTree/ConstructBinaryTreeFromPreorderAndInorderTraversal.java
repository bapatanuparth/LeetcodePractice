package leetcode150daysBTree;

//Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder, 0, inorder.length - 1);
	}

	int preIndex = 0;

	TreeNode build(int[] pre, int[] in, int istart, int iend) {
		if (istart > iend)
			return null;

		TreeNode root = new TreeNode(pre[preIndex++]);
		int inIndex = 0;

		for (int i = istart; i <= iend; i++) {
			if (in[i] == root.val) {
				inIndex = i;
				break;
			}
		}

		root.left = build(pre, in, istart, inIndex - 1);
		root.right = build(pre, in, inIndex + 1, iend);

		return root;
	}

}
