package leetcode150daysDynamicProgramming;

//Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {

		int sum = 0;
		for (int i : nums)
			sum += i;
		if (sum % 2 == 1)
			return false;

		int halfsum = sum / 2;

		boolean dp[] = new boolean[halfsum + 1];
		dp[0] = true;

		for (int i = 0; i < nums.length; i++) {

			boolean[] temp = new boolean[halfsum + 1]; // need to use this to avoid concurrent modification
			for (int j = 0; j < dp.length; j++) {

				if (dp[j] == true) {
					temp[j] = true;
					if (nums[i] + j < dp.length)
						temp[j + nums[i]] = true;
				}
			}

			dp = temp;

		}

		return dp[halfsum];

	}

}
