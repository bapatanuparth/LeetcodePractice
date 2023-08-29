package leetcode150daysLinkedList;

//You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

public class AddTwoNumbersII {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode h1 = reverse(l1);
		ListNode h2 = reverse(l2);
		ListNode dummy = new ListNode(-1);
		ListNode dummyhead = dummy;

		int sum = 0, carry = 0;
		while (h1 != null || h2 != null) {
			sum = h1 == null ? 0 : h1.val;
			sum += h2 == null ? 0 : h2.val;
			sum += carry;
			// System.out.println(sum);
			dummy.next = new ListNode(sum % 10);
			dummy = dummy.next;
			carry = sum / 10;
			h1 = h1 != null ? h1.next : null;
			h2 = h2 != null ? h2.next : null;
		}
		if (carry != 0) {
			dummy.next = new ListNode(1);
			dummy = dummy.next;
		}

		return reverse(dummyhead.next);

	}

	ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode rev_head = reverse(head.next);
		ListNode rev_tail = head.next;
		head.next = null;
		rev_tail.next = head;

		return rev_head;
	}

}
