package leetcode150daysBST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
//
//The encoded string should be as compact as possible.

public class SerializeAndDeserializeBST {

	public class Codec {
		private static final String SEP = ",";
		private static final String NULL = "null";

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			if (root == null)
				return NULL;
			// traverse it recursively if you want to, I am doing it iteratively here
			Stack<TreeNode> st = new Stack<>();
			st.push(root);
			while (!st.empty()) {
				root = st.pop();
				sb.append(root.val).append(SEP);
				if (root.right != null)
					st.push(root.right);
				if (root.left != null)
					st.push(root.left);
			}
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		// pre-order traversal
		public TreeNode deserialize(String data) {
			if (data.equals(NULL))
				return null;
			String[] strs = data.split(SEP);
			Queue<Integer> q = new LinkedList<>();
			for (String e : strs) {
				q.offer(Integer.parseInt(e));
			}
			return getNode(q);
		}

		// some notes:
		// 5
		// 3 6
		// 2 7
		private TreeNode getNode(Queue<Integer> q) { // q: 5,3,2,6,7
			if (q.isEmpty())
				return null;
			TreeNode root = new TreeNode(q.poll());// root (5)
			Queue<Integer> samllerQueue = new LinkedList<>();
			while (!q.isEmpty() && q.peek() < root.val) {
				samllerQueue.offer(q.poll());
			}
			// smallerQueue : 3,2 storing elements smaller than 5 (root)
			root.left = getNode(samllerQueue);
			// q: 6,7 storing elements bigger than 5 (root)
			root.right = getNode(q);
			return root;
		}
	}

}
