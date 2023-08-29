package leetcode150daysLinkedList;

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0, sum = 0;
		ListNode temp = new ListNode();
		ListNode head = temp;

		while (l1 != null || l2 != null) {
			if (l1 == null) {
				sum = carry + l2.val;
				l2 = l2.next;
			} else if (l2 == null) {
				sum = carry + l1.val;
				l1 = l1.next;
			} else {
				sum = carry + l1.val + l2.val;
				l1 = l1.next;
				l2 = l2.next;
			}
			temp.next = new ListNode(sum % 10);
			carry = sum / 10;
			temp = temp.next;
		}
		if (carry != 0) {
			temp.next = new ListNode(carry);
		}

		return head.next;
	}
}
