package leetcode150daysStackAndQueue;

import java.util.Stack;

//Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
//
//Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

public class BasicCalculator {

	public int calculate(String s) {
		int res = 0;
		int sign = 1;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					sum = sum * 10 + (s.charAt(i + 1) - '0');
					i++;
				}
				res += (sum * sign);
			} else if (s.charAt(i) == '+') {
				sign = 1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == '(') {
				st.push(res);
				st.push(sign);
				res = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				res = res * st.pop();
				res += st.pop();
			}
		}

		return res;
	}

}
