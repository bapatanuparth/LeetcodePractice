package leetcode150daysStackAndQueue;

//You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
//
//We repeatedly make k duplicate removals on s until we no longer can.
//
//Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

public class RemoveAllAdjacentDuplicatesInStringII {

//	public String removeDuplicates(String s, int k) {
//		Stack<Pair<Character, Integer>> st = new Stack<>();
//
//		for (int i = 0; i < s.length(); i++) {
//			char ch = s.charAt(i);
//			if (!st.isEmpty() && st.peek().getKey() == ch && st.peek().getValue() == k - 1) {
//				int count = 0;
//				while (!st.isEmpty() && count < k - 1) {
//					st.pop();
//					count++;
//				}
//			} else if (!st.isEmpty() && st.peek().getKey() == ch) {
//				st.push(new Pair(ch, st.peek().getValue() + 1));
//			} else {
//				st.push(new Pair(ch, 1));
//			}
//		}
//
//		if (st.isEmpty())
//			return "";
//		StringBuilder sb = new StringBuilder();
//		while (!st.isEmpty()) {
//			sb.append(st.pop().getKey());
//		}
//
//		return sb.reverse().toString();
//	}

}
