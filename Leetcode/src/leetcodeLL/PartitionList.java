package leetcodeLL;

//Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.

//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		// save the smaller part in new list before and bigger part in list after
		// then merge these 2 lists

		ListNode before = new ListNode(0);
		ListNode beforehead = before;

		ListNode after = new ListNode(0);
		ListNode afterhead = after;

		while (head != null) {

			if (head.val < x) {
				before.next = head;
				before = before.next;
			} else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}

		after.next = null;

		before.next = afterhead.next;

		return beforehead.next;

	}
}
