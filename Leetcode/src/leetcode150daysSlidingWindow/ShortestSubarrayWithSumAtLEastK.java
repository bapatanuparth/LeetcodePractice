package leetcode150daysSlidingWindow;

import java.util.ArrayDeque;

//Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.
//
//A subarray is a contiguous part of an array.

public class ShortestSubarrayWithSumAtLEastK {

	public int shortestSubarray(int[] nums, int k) {
		long presum[] = new long[nums.length + 1];

		for (int i = 0; i < nums.length; i++)
			presum[i + 1] = presum[i] + nums[i];
		ArrayDeque<Integer> d = new ArrayDeque<>();

		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= nums.length; i++) {
			while (!d.isEmpty() && presum[i] - presum[d.peekFirst()] >= k)
				min = Math.min(min, i - d.pollFirst());
			while (!d.isEmpty() && presum[i] <= presum[d.peekLast()])
				d.pollLast();
			d.offerLast(i);

		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}

}
