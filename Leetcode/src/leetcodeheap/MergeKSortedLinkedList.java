package leetcodeheap;

import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class MergeKSortedLinkedList {

	// naive approach using priority queue
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;

		Queue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);

		// push all nodes in a pq, pop one by one and form a linked list
		for (ListNode head : lists) {

			ListNode next = head;
			while (head != null) {
				next = head.next;
				q.add(head);
				head.next = null;
				head = next;
			}
		}

		ListNode head = q.poll();
		ListNode temp = head;

		while (!q.isEmpty()) {
			temp.next = q.poll();
			temp = temp.next;
		}

		return head;
	}
}
