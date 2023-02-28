package leetcodeTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Given the root of a binary tree, return all duplicate subtrees.
//
//For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//
//Two trees are duplicate if they have the same structure with the same node values.

public class FindDuplicateSubtrees {

	List<TreeNode> res = new ArrayList<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

		traverse(root, new HashMap<>());

		return res;
	}

	String traverse(TreeNode root, HashMap<String, Integer> map) {
		if (root == null)
			return "";
		// these opening and closing brackets to mark the subtree are important
		String rep = "(" + traverse(root.left, map) + ")" + root.val + "(" + traverse(root.right, map) + ")";

		map.put(rep, map.getOrDefault(rep, 0) + 1);

		if (map.get(rep) == 2)
			res.add(root);

		return rep;
	}

}
