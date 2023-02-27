package leetcodeTree;

import java.util.ArrayList;
import java.util.List;

//Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.
//
//Two nodes of a binary tree are cousins if they have the same depth with different parents.
//
//Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

public class IsCousinNodes {

	// cleaner solution code
	private List<Integer> pathFromRoot(TreeNode root, int x) {
		if (root.val == x) {
			List<Integer> res = new ArrayList<>();
			res.add(root.val);
			return res;
		}

		if (root.left != null) {
			List<Integer> l = pathFromRoot(root.left, x);
			if (l.size() > 0) {
				l.add(root.val);
				return l;
			}
		}

		if (root.right != null) {
			List<Integer> r = pathFromRoot(root.right, x);
			if (r.size() > 0) {
				r.add(root.val);
				return r;
			}
		}

		return new ArrayList<Integer>();
	}

	public boolean isCousinsEff(TreeNode root, int x, int y) {
		List<Integer> pathX = pathFromRoot(root, x);
		List<Integer> pathY = pathFromRoot(root, y);

		if (pathX.size() != pathY.size())
			return false;
		return pathX.get(1) != pathY.get(1);
	}

//my code ----------------
	public boolean isCousins(TreeNode root, int x, int y) {
		int a = depth(root, x, y);
		found = false;
		return a == depth(root, y, x);
	}

	// to keep a track if element found
	boolean found = false;

	public int depth(TreeNode root, int n1, int n2) {
		// if element is already found, stop more recursive calls to right subtrees,
		// directly return 0 as element is already found in another subtree
		if (root == null || found)
			return 0;

		// if element found, return its depth as 1 for total depth calculations
		if (root.val == n1) {
			found = true;
			return 1;
		}

		// lh == get depth in left subtree if not the current root
		int lh = depth(root.left, n1, n2);
		// lh ==1 will be only when we are on the parent of the n1 node
		if (lh == 1) {
			// check if the same parent has another child == n2
			if (root.right != null && root.right.val == n2)
				// if both n1 and n2 are children of same parent, they are not cousins = hence
				// offset their depth so it wont match
				return -1;
		}
		// rh == get depth of node in right subtree
		int rh = depth(root.right, n1, n2);
		// finally as node will be on either left or right subtree, we may have only lh
		// or rh >1
		if (found) {
			// if node found, then go on adding one till we reach the starting root to get
			// full deoth of current node
			return lh + rh + 1;
		}
		// this will return 0 if node is not found
		return lh;

	}
}
