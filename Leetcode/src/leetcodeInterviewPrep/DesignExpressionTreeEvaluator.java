package leetcodeInterviewPrep;

import java.util.Stack;

//Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents this expression.
//
//Postfix notation is a notation for writing arithmetic expressions in which the operands (numbers) appear before their operators. For example, the postfix tokens of the expression 4*(5-(7+2)) are represented in the array postfix = ["4","5","7","2","+","-","*"].
//
//The class Node is an interface you should use to implement the binary expression tree. The returned tree will be tested using the evaluate function, which is supposed to evaluate the tree's value. You should not remove the Node class; however, you can modify it as you wish, and you can define other classes to implement it if needed.
//
//A binary expression tree is a kind of binary tree used to represent arithmetic expressions. Each node of a binary expression tree has either zero or two children. Leaf nodes (nodes with 0 children) correspond to operands (numbers), and internal nodes (nodes with two children) correspond to the operators '+' (addition), '-' (subtraction), '*' (multiplication), and '/' (division).
//
//It's guaranteed that no subtree will yield a value that exceeds 109 in absolute value, and all the operations are valid (i.e., no division by zero).
//
//Follow up: Could you design the expression tree such that it is more modular? For example, is your design able to support additional operators without making changes to your existing evaluate implementation?

//Input: s = ["3","4","+","2","*","7","/"]
//Output: 2
public class DesignExpressionTreeEvaluator {

	/**
	 * This is the interface for the expression tree Node. You should not remove it,
	 * and you can define some classes to implement it.
	 */

	abstract class Node {
		public abstract int evaluate();
		// define your fields here
	};

	class NumNode extends Node {
		int val;

		public NumNode(int v) {
			this.val = v;
		}

		public int evaluate() {
			return val;
		}

	}

	abstract class OpNode extends Node {

		Node left;
		Node right;

		public OpNode(Node left, Node right) {
			this.left = left;
			this.right = right;
		}
	}

	class AddNode extends OpNode {

		public AddNode(Node left, Node right) {
			super(left, right);
		}

		public int evaluate() {
			return this.left.evaluate() + this.right.evaluate();
		}
	}

	class SubNode extends OpNode {
		public SubNode(Node left, Node right) {
			super(left, right);
		}

		public int evaluate() {
			return this.left.evaluate() - this.right.evaluate();
		}

	}

	class DivNode extends OpNode {
		public DivNode(Node left, Node right) {
			super(left, right);
		}

		public int evaluate() {
			return this.left.evaluate() / this.right.evaluate();
		}

	}

	class MulNode extends OpNode {
		public MulNode(Node left, Node right) {
			super(left, right);
		}

		public int evaluate() {
			return this.left.evaluate() * this.right.evaluate();
		}

	}

	/**
	 * This is the TreeBuilder class. You can treat it as the driver code that takes
	 * the postinfix input and returns the expression tree represnting it as a Node.
	 */

	class TreeBuilder {
		Node buildTree(String[] postfix) {

			Stack<Node> st = new Stack<>();

			for (String s : postfix) {

				if (Character.isDigit(s.charAt(0))) {
					st.push(new NumNode(Integer.parseInt(s)));
				} else {
					Node right = st.pop();
					Node left = st.pop();

					st.push(buildNode(left, right, s));
				}
			}

			return st.peek();
		}

		Node buildNode(Node left, Node right, String s) {

			switch (s) {
			case "+":
				return new AddNode(left, right);
			case "-":
				return new SubNode(left, right);
			case "*":
				return new MulNode(left, right);
			case "/":
				return new DivNode(left, right);
			default:
				return null;
			}
		}
	};

	/**
	 * Your TreeBuilder object will be instantiated and called as such: TreeBuilder
	 * obj = new TreeBuilder(); Node expTree = obj.buildTree(postfix); int ans =
	 * expTree.evaluate();
	 */
}
