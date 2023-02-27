package leetcodeLL;

public class DeleteNNodesAfterMNodesOfLL {

	public ListNode deleteNodes(ListNode head, int m, int n) {
		if (head == null)
			return null;
		ListNode temp = head;

		int mcheck = 1, ncheck = 1;
		while (temp != null) {

			// go m steps ahead
			while (temp != null && mcheck < m) {
				temp = temp.next;
				mcheck++;
			}
			if (temp == null)
				return head;

			// remove next n nodes
			ListNode next = temp.next;
			while (next != null && ncheck < n) {
				next = next.next;
				ncheck++;
			}
			if (next == null) {
				temp.next = next;
				return head;
			}
			temp.next = next.next;
			ncheck = 1;
			mcheck = 1;
			temp = temp.next;
		}

		return head;
	}
}
