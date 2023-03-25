package leetcodeSlidingWindow;

//Given an array of positive integers nums and a positive integer target, return the minimal length of a 
//subarray
// whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

public class MinimumSizeSubarraySum {

	// elegant sliding window
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0, right = 0;
		int sum = 0;
		int ans = Integer.MAX_VALUE;
		for (; right < nums.length; right++) {
			int val = nums[right];
			sum += val;
			while (sum >= target) {
				ans = Math.min(right - left + 1, ans);
				sum -= nums[left];
				left++;
			}
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}

}
