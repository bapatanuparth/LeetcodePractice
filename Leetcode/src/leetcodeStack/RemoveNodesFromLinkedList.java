package leetcodeStack;

import java.util.Stack;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class RemoveNodesFromLinkedList {

	public ListNode removeNodes(ListNode head) {
		Stack<ListNode> st = new Stack<>();

		ListNode temp = head;

		while (temp != null) {

			while (!st.isEmpty() && st.peek().val < temp.val) {

				st.pop();
			}
			ListNode val = temp;
			temp = temp.next;
			val.next = null;
			st.push(val);

		}

		if (st.isEmpty())
			return null;
		ListNode rev = st.pop();
		ListNode revnext = rev;
		while (!st.isEmpty()) {

			revnext.next = st.pop();
			revnext = revnext.next;

		}

		ListNode prev = null, curr = rev, next = curr;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}
}
