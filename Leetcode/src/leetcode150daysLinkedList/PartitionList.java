package leetcode150daysLinkedList;

//Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		ListNode before = new ListNode(0);
		ListNode after = new ListNode(0);

		ListNode beforehead = before;
		ListNode afterhead = after;

		ListNode temp = head;
		while (temp != null) {
			if (temp.val < x) {
				before.next = temp;
				before = before.next;
			} else {
				after.next = temp;
				after = after.next;
			}
			ListNode node = temp.next;
			temp.next = null;
			temp = node;
		}

		before.next = afterhead.next;
		return beforehead.next;

	}

}
