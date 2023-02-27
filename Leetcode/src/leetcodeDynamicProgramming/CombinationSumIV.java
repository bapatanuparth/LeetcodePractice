package leetcodeDynamicProgramming;
//Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

//
//The test cases are generated so that the answer can fit in a 32-bit integer.

public class CombinationSumIV {
	// we need to find permutations that also allow duplicates
	public int combinationSum4(int[] nums, int target) {

		// 1D as duplicates are allowed
		int dp[] = new int[target + 1];
		dp[0] = 1;

		// outer loop on target value
		for (int i = 1; i <= target; i++) {

			// inner loop runs over all the elements of array again, this gives permutations
			for (int j = 0; j < nums.length; j++) {

				// we add the weays to reach to that element if its < arr[j]
				if (i - nums[j] >= 0) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}

		return dp[target];
	}

}
