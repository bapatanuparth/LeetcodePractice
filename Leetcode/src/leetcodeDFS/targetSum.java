package leetcodeDFS;

//You are given an integer array nums and an integer target.
//
//You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
//
//For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
//Return the number of different expressions that you can build, which evaluates to target.

public class targetSum {

	int ways = 0;

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
