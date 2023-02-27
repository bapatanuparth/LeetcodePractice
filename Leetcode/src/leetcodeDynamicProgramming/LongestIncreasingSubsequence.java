package leetcodeDynamicProgramming;

public class LongestIncreasingSubsequence {

	// tabulation solution
	static int longestSubsequence(int size, int a[]) {
		// code here
		int[] dp = new int[size + 1];

		dp[0] = 1; // single element will have LIS == 1

		int omax = 0;
		for (int i = 1; i < a.length; i++) {
			int max = 0;

			for (int j = 0; j < i; j++) {
				if (a[j] < a[i])
					if (dp[j] > max)
						max = dp[j];
			}
			dp[i] = max + 1;
			if (dp[i] > omax)
				omax = dp[i];
		}

		return omax;
	}

	// my solution without DP
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 1)
			return 1;

		return length(nums, nums.length - 2, nums[nums.length - 1]);
	}

	// traverse array in reverse order
	public int length(int[] nums, int n, int prev) {
		if (n < 0)
			return 1;

		int max;
		if (nums[n] < prev) { // if current < prev , we have 2 cases 1. we consider this current in our
								// addition 2. we do not consider in our addition
			max = Math.max(1 + length(nums, n - 1, nums[n]), length(nums, n - 1, prev));
		} else // similarly if current>=prev, we have 2 cases 1. we either ignore previous and
				// make curr == prev, 2. or we ignore current and go to the next element and
				// compare with previous
			max = Math.max(length(nums, n - 1, prev), length(nums, n - 1, nums[n]));
		return max;
	}
}
