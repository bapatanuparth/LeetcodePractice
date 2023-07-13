package leetcode150daysLinkedList;

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == headB)
			return headA;

		// for O(1) space complexity --
		// count number of nodes in both the lists
		// while counting, check for an edge case where one of the lists donbt have any
		// node before intersection
		ListNode curA = headA;
		int countA = 0;
		while (curA != null) {
			if (curA.next == headB)
				return headB;
			curA = curA.next;
			countA++;
		}

		ListNode curB = headB;
		int countB = 0;
		while (curB != null) {
			if (curB.next == headA)
				return headA;
			curB = curB.next;
			countB++;
		}

		// after counting, make the offset as zero so that we can compare their next
		// elements
		// move pointer ahead for the one with the higher count so that we can check
		// where is the intersection happening
		curA = headA;
		curB = headB;
		while (countA > countB) {
			curA = curA.next;
			countA--;
		}

		while (countB > countA) {
			curB = curB.next;
			countB--;
		}

		while (curA != null && curB != null) {
			if (curA.next == curB.next)
				return curA.next;
			curA = curA.next;
			curB = curB.next;
		}

		return null;
	}

}
