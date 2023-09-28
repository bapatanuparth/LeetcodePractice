package leetcodeBFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
//
//The lock initially starts at '0000', a string representing the state of the 4 wheels.
//
//You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
//
//Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
//
// 

public class OpenTheLock {

	public int openLock(String[] deadends, String target) {
		Set<String> dead = new HashSet();
		for (String d : deadends)
			dead.add(d);

		Queue<String> queue = new LinkedList();
		queue.offer("0000");
		queue.offer(null);

		Set<String> seen = new HashSet();
		seen.add("0000");

		int depth = 0;
		while (!queue.isEmpty()) {
			String node = queue.poll();
			if (node == null) {
				depth++;
				if (queue.peek() != null)
					queue.offer(null);
			} else if (node.equals(target)) {
				return depth;
			} else if (!dead.contains(node)) {
				for (int i = 0; i < 4; ++i) {
					for (int d = -1; d <= 1; d += 2) {
						int y = ((node.charAt(i) - '0') + d + 10) % 10;
						String nei = node.substring(0, i) + ("" + y) + node.substring(i + 1);
						if (!seen.contains(nei)) {
							seen.add(nei);
							queue.offer(nei);
						}
					}
				}
			}
		}
		return -1;
	}

}
