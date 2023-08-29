package leetcode150daysLinkedList;

//Given the head of a linked list, remove the nth node from the end of the list and return its head.

public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null)
			return null;
		ListNode fast = head;
		ListNode slow = head;

		while (n-- > 0) {
			fast = fast.next;
		}

		if (fast == null)
			return slow.next;

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;

		return head;
	}
}
