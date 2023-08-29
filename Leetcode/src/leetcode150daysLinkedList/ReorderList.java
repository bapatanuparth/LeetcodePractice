package leetcode150daysLinkedList;

public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode prev = null;
		ListNode curr = slow;
		ListNode next = curr;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		ListNode head2 = prev;
		ListNode head1 = head;

		ListNode head1next = head1;
		ListNode head2next = head2;

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
