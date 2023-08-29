package leetcode150daysStackAndQueue;

import java.util.Stack;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//Implement the MinStack class:
//
//MinStack() initializes the stack object.
//void push(int val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//You must implement a solution with O(1) time complexity for each function.

public class MinStack {

	class MinStack {

		Stack<Pair<Integer, Integer>> st;

		public MinStack() {
			st = new Stack<>();
		}

		public void push(int val) {
			// Pair<Integer, Integer> pair= new Pair<>();
			if (st.isEmpty()) {
				st.push(new Pair<>(val, val));
				return;
			}
			int min = st.peek().getValue();
			if (val < min)
				st.push(new Pair<>(val, val));
			else
				st.push(new Pair<>(val, min));
		}

		public void pop() {
			st.pop();

		}

		public int top() {
			return st.peek().getKey();

		}

		public int getMin() {
			return st.peek().getValue();
		}
	}

	/**
	 * Your MinStack object will be instantiated and called as such: MinStack obj =
	 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
	 * param_4 = obj.getMin();
	 */

}
