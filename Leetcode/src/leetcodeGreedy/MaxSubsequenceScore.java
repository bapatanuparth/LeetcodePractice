package leetcodeGreedy;

import java.util.Arrays;
import java.util.PriorityQueue;

//You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.
//
//For chosen indices i0, i1, ..., ik - 1, your score is defined as:
//
//The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
//It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
//Return the maximum possible score.
//
//A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.

public class MaxSubsequenceScore {
//	We iterate all pairs (A[i], B[i]) with B[i] from big to small,
//	We keep the priority queue with maximum size of k.
//	Each time when we introduce a new pair of (A[i], B[i]),
//	the current minimum value on B is B[i]
//	the current sum value on A is sum(priority queue)
//
//	If the size of queue > k,
//	we pop the minimum A[i].
//	also update total sum -= A[i]
//
//	If the size of queue == k,
//	we update res = res = max(res, sum * B[i])

	public long maxScore(int[] nums1, int[] nums2, int k) {
		int n = nums1.length;
		int[][] arr = new int[n][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[] { nums2[i], nums1[i] };
		}
		Arrays.sort(arr, (a, b) -> b[0] - a[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

		long sum = 0, max = 0;
		for (int[] eq : arr) {
			pq.add(eq[1]);
			sum += eq[1];
			if (pq.size() > k)
				sum -= pq.poll();
			if (pq.size() == k)
				max = Math.max(max, sum * eq[0]);
		}

		return max;
	}

}
