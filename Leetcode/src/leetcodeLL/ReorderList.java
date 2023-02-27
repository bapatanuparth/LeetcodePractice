package leetcodeLL;

//You are given the head of a singly linked-list. The list can be represented as:
//
//L0 L1 … Ln -1 Ln
//Reorder the list to be on the following form:
//
//L0 Ln  L1  Ln - 1  L2  Ln - 2  …
//You may not modify the values in the list's nodes. Only nodes themselves may be changed
public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		// find midpoint
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// reverse linked list from midpoint
		ListNode prev = null;
		ListNode curr = slow;
		ListNode next = curr;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		// have 2 heads, 1 from beginning and 1 from mid, and go making joints from
		// head1 -> head2, and head2-> head1.next
		ListNode head2 = prev;
		ListNode head1 = head;

		ListNode head1next = head1;
		ListNode head2next = head2;

		// head.next == slow means when we find midpoint, we didnt break the previous
		// link that joined midpoint
		// so when head1.next==slow, it means thats the last link from 1st part
		// so we change it to head2 to complete reorder
		while (head1.next != slow && head2next != null) {
			head1next = head1.next;
			head2next = head2.next;
			head1.next = head2;
			head2.next = head1next;
			head1 = head1next;
			head2 = head2next;
		}
		if (head1.next == slow)
			head1.next = head2;

	}
}
