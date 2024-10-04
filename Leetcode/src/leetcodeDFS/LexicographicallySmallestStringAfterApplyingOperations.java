package leetcodeDFS;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LexicographicallySmallestStringAfterApplyingOperations {

	Set<String> seen;
	String ans;
	PriorityQueue<String> pq;

	public String findLexSmallestString(String s, int a, int b) {
		seen = new HashSet<>();
		pq = new PriorityQueue<>((x, y) -> x.compareTo(y));
		dfs(s, a, b);
		// System.out.println(seen);
		return pq.poll();
	}

	void dfs(String s, int a, int b) {
		String rotated = rotate(s, b);
		if (!seen.contains(rotated)) {
			seen.add(rotated);
			pq.offer(rotated);
			dfs(rotated, a, b);
		}

		String added = add(s, a);
		if (!seen.contains(added)) {
			seen.add(added);
			pq.offer(added);
			dfs(added, a, b);
		}
	}

	String rotate(String s, int b) {
		int n = s.length();
		String rotated = s.substring(n - b) + s.substring(0, n - b);
		return rotated;
	}

	String add(String s, int a) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 1; i < sb.length(); i += 2) {
			int ch = sb.charAt(i) - '0';
			int newint = (ch + a) % 10;
			sb.setCharAt(i, (char) (newint + '0'));
		}
		return sb.toString();
	}
}
