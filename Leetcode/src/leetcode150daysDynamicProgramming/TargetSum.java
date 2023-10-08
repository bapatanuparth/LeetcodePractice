package leetcode150daysDynamicProgramming;

import java.util.Arrays;

//You are given an integer array nums and an integer target.
//
//You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
//
//For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
//Return the number of different expressions that you can build, which evaluates to target.

public class TargetSum {

	int[][] dp;

	public int findTargetSumWays(int[] nums, int target) {
		dp = new int[2001][21];
		for (int i = 0; i < dp.length; i++)
			Arrays.fill(dp[i], -1);
		return dfs(0, 0, target, nums);
	}

	int dfs(int sum, int i, int target, int nums[]) {
		if (sum == target && i == nums.length)
			return 1;

		if (i >= nums.length)
			return 0;

		if (dp[sum + 1000][i] != -1)
			return dp[sum + 1000][i];

		int ways = dfs(sum + nums[i], i + 1, target, nums);
		ways += dfs(sum - nums[i], i + 1, target, nums);

		dp[sum + 1000][i] = ways;
		return ways;
	}

}
