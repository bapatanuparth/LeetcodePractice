package leetcodeLL;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextLargerNode {

	public int[] nextLargerNodes(ListNode head) {

		// use concept of monotonic stack
		Stack<Integer> st = new Stack<>();
		List<Integer> arr = new ArrayList<>();

		ListNode temp = head;
		while (temp != null) {
			arr.add(temp.val);
			temp = temp.next;
		}

		int[] res = new int[arr.size()];

		for (int i = 0; i < arr.size(); i++) {

			int key = arr.get(i);

			while (!st.isEmpty() && arr.get(st.peek()) < key) {
				res[st.peek()] = key;
				st.pop();
			}
			st.push(i);
		}

		while (!st.isEmpty()) {
			res[st.peek()] = 0;
			st.pop();
		}

		return res;
	}
}
