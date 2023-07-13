package leetcode150daysLinkedList;

//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.

public class MergeTwoSortedLinkedLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}
		if (list1 == null || list2 == null) {
			return list1 == null ? list2 : list1;
		}
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				cur.next = list1;
				list1 = list1.next;
			} else {
				cur.next = list2;
				list2 = list2.next;
			}
			cur = cur.next;
		}
		if (list1 == null) {
			cur.next = list2;
		}
		if (list2 == null) {
			cur.next = list1;
		}
		return dummy.next;
	}
}
