package leetcodeDynamicProgramming;

//You are given a 0-indexed integer array nums. You have to partition the array into one or more contiguous subarrays.
//
//We call a partition of the array valid if each of the obtained subarrays satisfies one of the following conditions:
//
//The subarray consists of exactly 2 equal elements. For example, the subarray [2,2] is good.
//The subarray consists of exactly 3 equal elements. For example, the subarray [4,4,4] is good.
//The subarray consists of exactly 3 consecutive increasing elements, that is, the difference between adjacent elements is 1. For example, the subarray [3,4,5] is good, but the subarray [1,3,5] is not.
//Return true if the array has at least one valid partition. Otherwise, return false.

public class CheckIfThereIsValidPartitionInArray {

	public boolean validPartition(int[] nums) {
		int n = nums.length;
		boolean dp[] = new boolean[nums.length + 1];

		dp[0] = true;
		for (int i = 2; i <= n; i++) {
			dp[i] |= nums[i - 1] == nums[i - 2] && dp[i - 2]; // check first condition
			dp[i] |= i > 2 && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3] && dp[i - 3]; // check second
																										// condition
			dp[i] |= i > 2 && nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1 && dp[i - 3]; // check
																												// third
																												// condition
		}

		return dp[n];
	}

}
