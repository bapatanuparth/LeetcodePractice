package leetcode150daysDynamicProgramming;

import java.util.Arrays;

//Given an integer array nums, return the length of the longest strictly increasing 
//subsequence
//.

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {

		int dp[] = new int[nums.length];

		Arrays.fill(dp, 1);
		int max = 1;

		for (int i = 1; i < dp.length; i++) {

			for (int j = 1; j <= i; j++) {

				if (nums[i] > nums[i - j])
					dp[i] = Math.max(dp[i], 1 + dp[i - j]);
			}
			max = Math.max(max, dp[i]);
		}

		return max;

	}

}
