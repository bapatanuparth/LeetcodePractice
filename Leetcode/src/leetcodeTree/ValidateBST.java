package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

	public boolean isValidBST(TreeNode root) {
		List<Integer> ls = new ArrayList<>();
		return checkBST(root, ls);
	}

	// instead of calculating whole inorder first, pass the list and check while
	// adding every new element
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
