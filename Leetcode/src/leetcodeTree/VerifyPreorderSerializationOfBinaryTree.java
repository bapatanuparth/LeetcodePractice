package leetcodeTree;

import java.util.ArrayDeque;
import java.util.Deque;

//One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'.
//
//
//For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
//
//Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.
//
//It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.
//
//You may assume that the input format is always valid.
//
//For example, it could never contain two consecutive commas, such as "1,,3".
//Note: You are not allowed to reconstruct the tree.

public class VerifyPreorderSerializationOfBinaryTree {

	public boolean isValidSerializationM2o(String preorder) {
		// number of available slots
		int slots = 1;

		for (String node : preorder.split(",")) {
			// one node takes one slot
			--slots;

			// no more slots available
			if (slots < 0)
				return false;

			// non-empty node creates two children slots
			if (!node.equals("#"))
				slots += 2;
		}

		// all slots should be used up
		return slots == 0;
	}

	public boolean isValidSerialization(String preorder) {
		Deque<Pair<String, Integer>> st = new ArrayDeque<>();
		boolean first = true;
		String[] str = preorder.split(",");

		if (str.length == 1 && str[0].equals("#"))
			return true;
		else if (str[0].equals("#"))
			return false;

		st.offerLast(new Pair<>(str[0], 0));
		for (String ch : str) {
			if (first) {
				first = false;
				continue;
			}
			Pair<String, Integer> top = st.pollLast();

			while (!st.isEmpty() && top.getValue() == 2)
				top = st.pollLast();

			if (ch.equals("#")) {
				st.offerLast(new Pair<>(top.getKey(), top.getValue() + 1));
			} else {
				st.offerLast(new Pair<>(top.getKey(), top.getValue() + 1));
				st.offerLast(new Pair<>(ch, 0));
			}
			// System.out.println(st);
		}
		while (!st.isEmpty() && st.peekLast().getValue() == 2)
			st.pollLast();

		return st.isEmpty();
	}

}
