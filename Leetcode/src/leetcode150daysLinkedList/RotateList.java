package leetcode150daysLinkedList;

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		// calculate total number of nodes in List
		ListNode temp = head;
		int n = 0;
		while (temp != null) {
			temp = temp.next;
			n++;
		}
		// calculate offset
		int offset = k % n;
		if (offset == 0)
			return head;
		// get new head and tail
		ListNode fast = head, slow = head;
		while (offset != 0) {
			fast = fast.next;
			offset--;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		ListNode newHead = slow.next;
		fast.next = head;
		slow.next = null;

		return newHead;
	}

}
