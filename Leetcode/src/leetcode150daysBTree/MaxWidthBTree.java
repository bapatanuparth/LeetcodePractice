package leetcode150daysBTree;

import java.util.ArrayDeque;
import java.util.Deque;

//Given the root of a binary tree, return the maximum width of the given tree.
//
//The maximum width of a tree is the maximum width among all levels.
//
//The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
//
//It is guaranteed that the answer will in the range of a 32-bit signed integer.

public class MaxWidthBTree {

	public int widthOfBinaryTree(TreeNode root) {
//		Deque<Pair<TreeNode, Integer>> dq = new ArrayDeque<>();
//		dq.offerLast(new Pair(root, 0));
//
//		int maxWidth = 1;
//		while (!dq.isEmpty()) {
//			Pair<TreeNode, Integer> head = dq.peekFirst();
//			int size = dq.size();
//			Pair<TreeNode, Integer> elem = null;
//			while (size > 0) {
//				elem = dq.pollFirst();
//				if (elem.getKey().left != null) {
//					dq.offerLast(new Pair<>(elem.getKey().left, 2 * elem.getValue() + 1));
//				}
//				if (elem.getKey().right != null) {
//					dq.offerLast(new Pair<>(elem.getKey().right, 2 * elem.getValue() + 2));
//				}
//				size--;
//			}
//
//			maxWidth = Math.max(maxWidth, elem.getValue() - head.getValue() + 1);
//		}
//
//		return maxWidth;
//	}

}
