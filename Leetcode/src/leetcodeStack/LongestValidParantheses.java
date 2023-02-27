package leetcodeStack;

import java.util.Stack;

public class LongestValidParantheses {
	// M1 use stack and array
//	First, stack push position of each '(', then when we meet ')' I pop stack to find its match'('. place both ')' and '(' as 1 in array
//	For example, (()() array should look like[0,1,1,1,1]
//	Then it is super easy, to find out longest substring that all items are 1 !!!
//	
	// M2

	public int longestValidParentheses(String s) {
		Stack<Integer> st = new Stack<>();
		st.push(-1);
		int max = 0;
		// store indices in the stack.
		// when u pop the element, max of index- st.peek() will be the answer
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				st.push(i);

			else {
				st.pop();
				if (st.isEmpty())
					st.push(i);
				max = Math.max(max, i - st.peek());
			}
		}

		return max;
	}
}
