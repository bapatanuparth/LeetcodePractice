package leetcode150daysDynamicProgramming;

//Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
//
//The test cases are generated so that the answer can fit in a 32-bit integer.

public class CombinationSumIV {

	public int combinationSum4(int[] nums, int target) {
		int dp[] = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j : nums) {
				if (j <= i) {
					dp[i] += dp[i - j];
				}
			}
		}
		return dp[target];
	}

}
