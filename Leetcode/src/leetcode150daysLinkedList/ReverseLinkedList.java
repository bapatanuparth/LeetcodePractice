package leetcode150daysLinkedList;

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

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode rev_head = reverseList(head.next);
		ListNode rev_tail = head.next;
		head.next = null;
		rev_tail.next = head;

		return rev_head;
	}

	public ListNode reverseListEff(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode curr = head, prev = null, next = curr;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

}
