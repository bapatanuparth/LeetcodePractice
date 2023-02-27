package leetcodeStack;

import java.util.Stack;
//
//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
//
//Note that division between two integers should truncate toward zero.
//
//It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6

//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9

//reverse polish notation is a postfix operation command
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
