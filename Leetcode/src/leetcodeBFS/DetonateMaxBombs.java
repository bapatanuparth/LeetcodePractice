package leetcodeBFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//You are given a list of bombs. The range of a bomb is defined as the area where its effect can be felt. This area is in the shape of a circle with the center as the location of the bomb.
//
//The bombs are represented by a 0-indexed 2D integer array bombs where bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate of the location of the ith bomb, whereas ri denotes the radius of its range.
//
//You may choose to detonate a single bomb. When a bomb is detonated, it will detonate all bombs that lie in its range. These bombs will further detonate the bombs that lie in their ranges.
//
//Given the list of bombs, return the maximum number of bombs that can be detonated if you are allowed to detonate only one bomb.

public class DetonateMaxBombs {

	// for each bomb, add it in queue,
	// for all other bombs, check if it lies in range and then add it in queue. i.e.
	// perform BFS on the bombs
	// keep track of max count

	public int maximumDetonation(int[][] bombs) {
		int maxDetonated = 0;
		for (int i = 0; i < bombs.length; i++) {
			Set<Integer> detonated = new HashSet<>();
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(i);
			while (!q.isEmpty()) {
				int cur = q.poll();
				if (detonated.contains(cur)) {
					continue;
				}
				detonated.add(cur);
				for (int j = 0; j < bombs.length; j++) {
					if (j != cur && distance(bombs[cur], bombs[j]) <= bombs[cur][2]) {
						q.offer(j);
					}
				}
			}
			if (detonated.size() > maxDetonated)
				maxDetonated = detonated.size();
		}
		return maxDetonated;
	}

	private double distance(int[] a, int[] b) {
		return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
	}
}
