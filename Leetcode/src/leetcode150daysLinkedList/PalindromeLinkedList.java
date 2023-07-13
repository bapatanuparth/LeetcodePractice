package leetcode150daysLinkedList;

//Given the head of a singly linked list, return true if it is a 
//palindrome
// or false otherwise.

public class PalindromeLinkedList {

	public ListNode findMid(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode curr = head, next = head, prev = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public boolean isPalindrome(ListNode head) {
		if (head.next == null)
			return true;

		ListNode mid = findMid(head);
		ListNode head2 = reverse(mid);

		ListNode curr = head;
		while (curr != null && head2 != null) {
			if (curr.val != head2.val)
				return false;
			curr = curr.next;
			head2 = head2.next;
		}

		return true;
	}

}
