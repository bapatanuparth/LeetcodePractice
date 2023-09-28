package leetcode150daysBTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//	Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//	Initially, all next pointers are set to NULL.

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

public class PopulatingNextRightPointerInEachNodeII {

	public Node connect(Node root) {
		if (root == null)
			return root;
		Map<Integer, List<Node>> map = new HashMap<>();
		connectHelper(root, 0, map);

		for (int key : map.keySet()) {
			List<Node> ls = map.get(key);

			for (int i = 0; i < ls.size() - 1; i++) {
				ls.get(i).next = ls.get(i + 1);
			}
		}
		return root;
	}

	void connectHelper(Node root, int lev, Map<Integer, List<Node>> map) {
		if (root == null)
			return;
		if (!map.containsKey(lev)) {
			map.put(lev, new ArrayList<>());
		}
		map.get(lev).add(root);
		connectHelper(root.left, lev + 1, map);
		connectHelper(root.right, lev + 1, map);
	}

}
