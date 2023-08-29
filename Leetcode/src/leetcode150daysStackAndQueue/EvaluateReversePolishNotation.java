package leetcode150daysStackAndQueue;

import java.util.Stack;

//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//
//Evaluate the expression. Return an integer that represents the value of the expression.
//
//Note that:
//
//The valid operators are '+', '-', '*', and '/'.
//Each operand may be an integer or another expression.
//The division between two integers always truncates toward zero.
//There will not be any division by zero.
//The input represents a valid arithmetic expression in a reverse polish notation.
//The answer and all the intermediate calculations can be represented in a 32-bit integer.

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {

		Stack<Integer> st = new Stack<>();

		int res = 0;
		for (int i = 0; i < tokens.length; i++) {
			String s = tokens[i];
			if (s.equals("/") || s.equals("*") || s.equals("-") || s.equals("+")) {
				int b = st.pop();
				int a = st.pop();
				int tempres = 0;

				if (s.equals("+"))
					tempres = a + b;

				else if (s.equals("-"))
					tempres = a - b;

				else if (s.equals("*"))
					tempres = a * b;

				else if (s.equals("/"))
					tempres = a / b;

				st.push(tempres);
			}

			else {
				st.push(Integer.parseInt(s));
			}
		}

		return st.pop();
	}

}
