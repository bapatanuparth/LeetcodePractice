package leetcodeLL;

import java.util.Stack;

public class RemoveNodesFromLinkedList {
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

	// Efficient recursion solution
	public ListNode removeNodesEfficient(ListNode head) {
		if (head == null)
			return null;
		head.next = removeNodes(head.next);
		return head.next != null && head.val < head.next.val ? head.next : head;
	}

	public ListNode removeNodes(ListNode head) {
		Stack<ListNode> st = new Stack<>();

		ListNode temp = head;

		// monotonic stack in descending order
		// add nodes in the stack and remove their chains
		// then, rejoin the nodes in the stack and reverse them
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
