package leetcodeLL;

//You are given two linked lists: list1 and list2 of sizes n and m respectively.
//
//Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
//
//The blue edges and nodes in the following figure indicate the result:
//
//
//Build the result list and return its head.

public class MergeInBetweenLinkedLists {

	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		// creating dummy in case we remove head node
		ListNode dummy = new ListNode(0);
		dummy.next = list1;

		int i = 1;
		ListNode tmp = list1;
		// find the starting point
		while (i < a) {
			tmp = tmp.next;
			i++;
		}
		ListNode newEnd = tmp.next;
		// find the endpoiint
		while (i < b) {
			newEnd = newEnd.next;
			i++;
		}
		// find end of list2
		ListNode list2End = list2;
		while (list2End.next != null)
			list2End = list2End.next;
		// make joins
		list2End.next = newEnd.next;
		tmp.next = list2;

		return dummy.next;

	}

}
