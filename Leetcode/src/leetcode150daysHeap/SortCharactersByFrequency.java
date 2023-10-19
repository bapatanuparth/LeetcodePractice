package leetcode150daysHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
//
//Return the sorted string. If there are multiple answers, return any of them.

public class SortCharactersByFrequency {

	public String frequencySort(String s) {

		Map<Character, Integer> map = new HashMap<>();

		Queue<Character> heap = new PriorityQueue<>((a, b) -> {
			return map.get(b) - map.get(a);
		});

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		// System.out.println(map);
		for (char c : map.keySet()) {
			heap.add(c);
		}

		StringBuilder sb = new StringBuilder();
		while (!heap.isEmpty()) {
			char c = heap.poll();
			for (int i = 0; i < map.get(c); i++)
				sb.append(c);
		}
		return sb.toString();

	}

}
