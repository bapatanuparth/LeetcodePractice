package leetcodeTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopulatingNextRightPointerII {
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

	public Node connect(Node root) {

		Map<Integer, List<Node>> map = new HashMap<>();
		connectHelper(root, map, 0); // create map for level --> list of nodes on that level

		for (int lev : map.keySet()) {
			List<Node> temp = map.get(lev); // iterate on all nodes of a level and join their next pointers to i+1 th
											// node

			for (int i = 0; i < temp.size() - 1; i++) {
				temp.get(i).next = temp.get(i + 1);
			}
			temp.get(temp.size() - 1).next = null;
		}

		return root;

	}

	// create a map that has key == level, val== list of all nodes at that level.
	void connectHelper(Node root, Map<Integer, List<Node>> map, int level) {
		if (root == null) {
			return;
		}
		if (!map.containsKey(level)) {
			map.put(level, new ArrayList<>());
		}
		map.get(level).add(root);
		connectHelper(root.left, map, level + 1);
		connectHelper(root.right, map, level + 1);
	}
}
