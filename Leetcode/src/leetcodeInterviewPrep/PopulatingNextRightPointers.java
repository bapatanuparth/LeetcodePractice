package leetcodeInterviewPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

public class PopulatingNextRightPointers {
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
	}

	// best solution for interview
	public Node connectEfficient(Node root) {
		if (root == null)
			return root;
		// while we are on the level N, make connections of level N+1
		// populate the next pointers for the next level from current level. then move a
		// level down, use those next pointers to make further connection on
		// inter-parent nodes
		Node leftmost = root;
		while (leftmost.left != null) {

			Node head = leftmost;
			while (head != null) {

				// connection 1
				head.left.next = head.right;

				// connection 2
				if (head.next != null) {
					head.right.next = head.next.left;
				}

				head = head.next;
			}

			leftmost = leftmost.left;
		}

		return root;
	}

	// using O(1) extra space
	// the solution can be further optimized
	public Node connect1(Node root) {
		if (root == null)
			return root;
		root.next = null;
		connectHelper(root.left, root.right);
		return root;
	}

	void connectHelper(Node node1, Node node2) {
		if (node1 == null)
			return;
		node1.next = node2;
		connectHelper(node1.left, node1.right);
		connectHelper(node1.right, node2.left);
		connectHelper(node2.left, node2.right);

	}

	// using O(n) extra space
	// could be done easily using level order traversal using Queue in normal way
	public Node connect(Node root) {

		Map<Integer, List<Node>> map = new HashMap<>();
		connectHelper(root, map, 0);

		for (int lev : map.keySet()) {
			List<Node> temp = map.get(lev);

			for (int i = 0; i < temp.size() - 1; i++) {
				temp.get(i).next = temp.get(i + 1);
			}
			temp.get(temp.size() - 1).next = null;
		}
		return root;
	}

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
