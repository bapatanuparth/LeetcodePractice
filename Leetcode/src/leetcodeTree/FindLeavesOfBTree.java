package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBTree {
	public List<List<Integer>> findLeaves(TreeNode root) {

		List<List<Integer>> out = new ArrayList<>();
		List<Integer> ls = new ArrayList<>();
		while (traverse(ls, root) != null) {
			out.add(new ArrayList<>(ls));
			ls.clear();
		}
		out.add(new ArrayList<>(ls));
		return out;
	}

	TreeNode traverse(List<Integer> ls, TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			ls.add(root.val);
			return null;
		}

		root.left = traverse(ls, root.left);
		root.right = traverse(ls, root.right);

		return root;
	}

}
