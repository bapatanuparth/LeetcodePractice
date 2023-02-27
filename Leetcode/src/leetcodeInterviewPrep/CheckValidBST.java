package leetcodeInterviewPrep;

import java.util.ArrayList;
import java.util.List;

public class CheckValidBST {

	// to check if tree is valid, perform in-order traversal as in-order traversal
	// gives sorted array for BST
	// during in-order traversal, we can check whether the current node < the last
	// node in list
	public boolean isValidBST(TreeNode root) {
		List<Integer> ls = new ArrayList<>();
		return checkBST(root, ls);
	}

	boolean checkBST(TreeNode root, List<Integer> list) {
		if (root == null)
			return true;
		if (!checkBST(root.left, list))
			return false;

		if (!list.isEmpty() && root.val <= list.get(list.size() - 1))
			return false;

		list.add(root.val);
		if (!checkBST(root.right, list))
			return false;
		return true;
	}
}
