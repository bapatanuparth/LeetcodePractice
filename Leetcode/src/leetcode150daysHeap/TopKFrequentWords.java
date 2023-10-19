package leetcode150daysHeap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//Given an array of strings words and an integer k, return the k most frequent strings.
//
//Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();

		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		Queue<String> minHeap = new PriorityQueue<>((a, b) -> {
			if (map.get(a) == map.get(b))
				return b.compareTo(a);
			else
				return map.get(a) - map.get(b);
		});

		for (String key : map.keySet()) {
			minHeap.add(key);
			if (minHeap.size() > k)
				minHeap.poll();
		}

		String[] res = new String[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = minHeap.poll();
		}

		// Collections.sort(op);
		return Arrays.asList(res);
	}

}
