package leetcode150daysLinkedList;

public class ReverseNodesInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		ListNode curr = head;
		int i = 0;
		for (i = 0; i < k && curr != null; i++) {
			curr = curr.next;
		}

		if (curr == null && i < k)
			return head;

		ListNode prev = reverseKGroup(curr, k);

		curr = head;
		for (i = 0; i < k; i++) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;

	}

}
