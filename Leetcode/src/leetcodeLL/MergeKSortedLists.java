package leetcodeLL;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

	// priority queue can be used to add all the nodes together and then form the
	// list again
	public ListNode mergeKListsExtraSpace(ListNode[] lists) {
		if (lists.length == 0)
			return null;

		Queue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);

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

	// merge all one by one
	// merge first two and then one by one add to the merged list
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode h = new ListNode(0);
		ListNode ans = h;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				h.next = l1;
				h = h.next;
				l1 = l1.next;
			} else {
				h.next = l2;
				h = h.next;
				l2 = l2.next;
			}
		}
		if (l1 == null) {
			h.next = l2;
		}
		if (l2 == null) {
			h.next = l1;
		}
		return ans.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 1) {
			return lists[0];
		}
		if (lists.length == 0) {
			return null;
		}
		ListNode head = mergeTwoLists(lists[0], lists[1]);
		for (int i = 2; i < lists.length; i++) {
			head = mergeTwoLists(head, lists[i]);
		}
		return head;
	}
}
