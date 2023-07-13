package leetcode150daysLinkedList;

//Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode left = head, right = head.next;
		while (right != null) {
			if (right.val == left.val) {
				left.next = right.next;
				right = right.next;
			} else {
				left = left.next;
				right = right.next;
			}
		}
		return head;
	}

}
