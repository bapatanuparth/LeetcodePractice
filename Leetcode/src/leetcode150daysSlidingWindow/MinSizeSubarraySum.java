package leetcode150daysSlidingWindow;

public class MinSizeSubarraySum {

	public int minSubArrayLen(int target, int[] nums) {
		int sum = 0;
		int left = 0, min = Integer.MAX_VALUE;
		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];
			while (left <= right && sum >= target) {
				min = Math.min(min, right - left + 1);
				sum -= nums[left];
				left++;
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

}
