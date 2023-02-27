package leetcodeheap;

import java.util.PriorityQueue;
import java.util.Queue;

//You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks. The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks. You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.
//
//Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.

public class MaxBagsWithFullCapacityOfRocks {

	public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

		int full = 0;
		Queue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < capacity.length; i++) {
			if (capacity[i] == rocks[i])
				full++;
			else
				q.add(capacity[i] - rocks[i]);
		}

		while (!q.isEmpty()) {
			int temp = q.poll();
			if (additionalRocks >= temp) {
				additionalRocks -= temp;
				full++;
			} else
				break;
		}

		return full;
	}
}
