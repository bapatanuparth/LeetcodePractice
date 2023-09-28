package leetcodeDFS;

import java.util.Arrays;

//You are given an integer array nums and an integer target.
//
//You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
//
//For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
//Return the number of different expressions that you can build, which evaluates to target.

public class targetSum {

	// memoized solution
	int memo[][];

	// time O(N*S) -- S== all possible sum range
	public int findTargetSumWaysMemo(int[] nums, int target) {
		memo = new int[nums.length][2001]; // to accomodate range -1000 to +1000
		for (int i = 0; i < nums.length; i++)
			Arrays.fill(memo[i], -1);

		return dfsMemo(nums, target, 0, 0);
	}

	int dfsMemo(int[] nums, int target, int i, int sum) {
		if (i == nums.length) {
			return sum == target ? 1 : 0;
		}

		if (memo[i][sum + 1000] != -1)
			return memo[i][sum + 1000];

		int ways = dfsMemo(nums, target, i + 1, sum - nums[i]) + dfsMemo(nums, target, i + 1, sum + nums[i]);

		memo[i][sum + 1000] = ways;
		return ways;
	}

	int ways = 0;

	// O(2^n)
	public int findTargetSumWays(int[] nums, int target) {
		dfs(nums, target, 0, 0);

		return ways;
	}

	void dfs(int[] nums, int target, int i, int sum) {

		if (sum == target && i == nums.length) {
			ways = ways + 1;
		}

		if (i == nums.length)
			return;
		// for each number you can either add it or subtract it
		// consider both the cases
		dfs(nums, target, i + 1, sum + nums[i]);
		dfs(nums, target, i + 1, sum - nums[i]);
	}

}
