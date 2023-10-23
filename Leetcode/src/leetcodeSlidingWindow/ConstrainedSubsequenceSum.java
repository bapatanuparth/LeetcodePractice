package leetcodeSlidingWindow;

import java.util.ArrayDeque;

//Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
//
//A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.

public class ConstrainedSubsequenceSum {

	public int constrainedSubsetSum(int[] nums, int k) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.offerLast(0);
		// dp with deque to maintain maximum of window
		for (int i = 1; i < nums.length; i++) {

			int max = dq.peekFirst();
			dp[i] = Math.max(nums[i], nums[i] + dp[max]);
			// put the current element in order such that first element of queue is max, and
			// monotonic in nature
			while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i])
				dq.pollLast();
			// add current element
			dq.offerLast(i);
			// check if the max element has gone out of window, if yes then remove it from
			// queue
			while (!dq.isEmpty() && dq.peekFirst() <= i - k)
				dq.pollFirst();
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++)
			ans = Math.max(ans, dp[i]);

		return ans;
	}

}
