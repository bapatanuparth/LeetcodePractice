package leetcode150daysHash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

public class UniqueNumberOfOcurrences {

	public boolean uniqueOccurrences(int[] arr) {
		// Store the frequency of elements in the unordered map.
		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : arr) {
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}

		// Store the frequency count of elements in the unordered set.
		Set<Integer> freqSet = new HashSet<>(freq.values());

		// If the set size is equal to the map size,
		// It implies frequency counts are unique.
		return freq.size() == freqSet.size();
	}

}
