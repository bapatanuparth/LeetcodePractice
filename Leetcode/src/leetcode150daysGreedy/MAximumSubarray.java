package leetcode150daysGreedy;

//Given an integer array nums, find the 
//subarray
// with the largest sum, and return its sum.

public class MAximumSubarray {

	public int maxSubArray(int[] nums) {
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}
