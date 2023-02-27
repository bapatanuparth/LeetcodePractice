package leetcodeBinarySearch;

import java.util.Arrays;

//You are given an integer array nums of length n, and an integer array queries of length m.
//
//Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].
//
//A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

public class LongestSubsequenceWithLimitedSum {

	public int[] answerQueries(int[] nums, int[] queries) {

		// as we are considering sum of subsequence, the order does not matter
		// sort the array
		// take prefix sum
		// find the highest prefix sum <= queries. val
		Arrays.sort(nums);
		int[] presum = new int[nums.length];
		int[] res = new int[queries.length];

		presum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			presum[i] = presum[i - 1] + nums[i];

		}

		for (int i = 0; i < queries.length; i++) {
			int val = queries[i];
			int left = 0, right = nums.length - 1;
			int minIndex = -1;

			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (presum[mid] == val) {
					minIndex = mid;
					left = mid + 1;
				} else if (presum[mid] > val) {
					right = mid - 1;
				} else {
					minIndex = mid;
					left = mid + 1;
				}
			}

			res[i] = minIndex + 1;
		}

		return res;
	}
}
