package leetcode150daysDynamicProgramming;

//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

public class HouseRobberII {

	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);

		int arr[] = new int[nums.length - 1];
		int arr2[] = new int[nums.length - 1];

		for (int i = 0; i < arr.length; i++)
			arr[i] = nums[i];
		for (int i = 1; i < nums.length; i++)
			arr2[i - 1] = nums[i];

		return Math.max(robHouse(arr), robHouse(arr2));
	}

	int robHouse(int[] nums) {

		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		int dp[] = new int[nums.length];

		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}

		return dp[nums.length - 1];
	}

}
