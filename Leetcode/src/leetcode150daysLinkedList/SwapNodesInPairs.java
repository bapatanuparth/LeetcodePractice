package leetcode150daysLinkedList;

//Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode curr = head, next = head.next;
		curr.next = swapPairs(next.next);
		next.next = curr;
		return next;

	}

}
