package leetcodeTree;

//Given the root of a binary tree, flatten the tree into a "linked list":
//
//The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
//The "linked list" should be in the same order as a pre-order traversal of the binary tree.
public class FlattenTreeIntoLinkedList {

	// we are building linked list from bottom to top
	TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev; // we save the value to be pointed to in prev in recursive calls
		root.left = null;
		prev = root;// this prev will be the one we will point to in the call stack when calls
					// resolution happens
	}
}
