
package leetcodeTree;

//Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

public class ConstructBinaryTreeFromInorderPostorder {

	int postIndex = 0;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		postIndex = postorder.length - 1;
		return build(inorder, postorder, 0, inorder.length - 1);
	}

	TreeNode build(int[] in, int[] post, int istart, int iend) {
		if (istart > iend || postIndex < 0)
			return null;

		TreeNode root = new TreeNode(post[postIndex--]);

		int inIndex = 0;
		for (int i = istart; i <= iend; i++) {
			if (in[i] == root.val) {
				inIndex = i;
				break;
			}
		}

		root.right = build(in, post, inIndex + 1, iend);
		root.left = build(in, post, istart, inIndex - 1);

		return root;
	}
}
