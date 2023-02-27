package leetcodeLL;

import java.util.HashMap;
import java.util.Map;

public class MRUQueue {

	class DNode {
		int val;
		DNode next;
		DNode prev;
	}

	Map<Integer, DNode> cache = new HashMap<>();
	DNode head;
	DNode tail;

	void setUp() {
		tail = new DNode();
		head = tail;
	}

	void addNode(DNode node) {
		node.prev = tail;
		node.next = tail.next;

		tail.next = node;
		tail = node;

	}

	int moveToTail(DNode node) {
		if (node.val == tail.val)
			return node.val;

		DNode prev = node.prev;
		DNode next = node.next;

		prev.next = node.next;
		next.prev = node.prev;

		tail.next = node;
		node.prev = tail;
		tail = node;

		return node.val;

	}

	public MRUQueue(int n) {

		setUp();
		int count = 1;
		while (count <= n) {

			DNode temp = new DNode();
			temp.val = count;

			cache.put(count, temp);

			addNode(temp);
			count++;
		}

		DNode temp = head.next;
	}

	public int fetch(int k) {

		DNode temp = head;

		int count = 1;
		while (count <= k) {
			temp = temp.next;
			count++;
		}

		return moveToTail(temp);

	}
}
