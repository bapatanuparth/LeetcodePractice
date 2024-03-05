package leetcodeDynamicProgramming;

//Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.
//
//Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.

public class PartitionArrayForMaximumSum {

	public int maxSumAfterPartitioning(int[] arr, int k) {
		int dp[] = new int[arr.length];
		dp[0] = arr[0];

		// dp[i] stores the result from 0 to i
		// now, for ith element, the answer will be
		// for each j from 0 to k
		// dp[i] = dp[i-j-1] + max(arr[i-1], arr[i-2], ...arr[i-j]) * j
		// the second term represents considering the maximum element for the window of
		// size j

		for (int i = 1; i < arr.length; i++) {
			int j = 0;
			int max = arr[i];

			while (j < k && i - j >= 0) {
				max = Math.max(max, arr[i - j]);
				dp[i] = Math.max(dp[i], i - j > 0 ? dp[i - j - 1] + max * (j + 1) : max * (j + 1));
				j++;
			}
		}

		return dp[dp.length - 1];
	}

}
