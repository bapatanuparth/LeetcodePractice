package leetcode150daysHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i : nums) {
			map.compute(i, (key, v) -> (v == null) ? 1 : v + 1);
		}

		Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int[] temp = new int[2];
			temp[0] = entry.getKey();
			temp[1] = entry.getValue();

			maxHeap.add(temp);
		}

		int[] output = new int[k];
		for (int i = 0; i < k; i++) {
			output[i] = maxHeap.poll()[0];
		}
		return output;
	}

}
