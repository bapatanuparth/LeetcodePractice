package leetcode150daysStackAndQueue;

import java.util.Stack;

//Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 

//substring

public class LongestValidParantheses {

	public int longestValidParentheses(String s) {
		Stack<Integer> st = new Stack<>();
		int max = 0;
		st.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(i);
			} else {
				st.pop();
				if (st.isEmpty())
					st.push(i);
				else
					max = Math.max(max, i - st.peek());
			}
		}

		return max;
	}

}
