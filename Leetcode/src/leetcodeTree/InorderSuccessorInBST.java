package leetcodeTree;

public class InorderSuccessorInBST {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;
		if (root.val <= p.val) {
			// go the element that is immediately larger than the p
			return inorderSuccessor(root.right, p);
		} else {
			// if root is larger, then check in left subtree if any other element in between
			// the root and p exists
			// in left subtree, fetch the immediate larger element thatn the p
			// if left == null, then return root as it was larger than p already
			TreeNode left = inorderSuccessor(root.left, p);
			return left != null ? left : root;
		}

	}
}
