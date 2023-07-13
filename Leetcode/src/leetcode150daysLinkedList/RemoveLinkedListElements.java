package leetcode150daysLinkedList;

//Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode curr = head;
		while (head != null && head.val == val)
			head = head.next;
		if (head == null)
			return null;
		while (curr != null && curr.next != null) {
			if (curr.next.val == val) {
				curr.next = curr.next.next;
			} else
				curr = curr.next;
		}
		return head;
	}

}
