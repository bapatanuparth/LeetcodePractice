package leetcodeDynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
//
//A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.

public class LongestArithmeticSubsequenceOfGivenDifference {

	class Solution {
		public int longestSubsequence(int[] arr, int difference) {
			Map<Integer, Integer> map = new HashMap<>();
			map.put(arr[0], 1);
			int max = 1;
			for (int i = 1; i < arr.length; i++) {
				int prev = arr[i] - difference;
				if (map.containsKey(prev)) {
					map.put(arr[i], map.get(prev) + 1);
				} else
					map.put(arr[i], 1);
				max = Math.max(max, map.get(arr[i]));
			}

			return max;
		}
	}

}
