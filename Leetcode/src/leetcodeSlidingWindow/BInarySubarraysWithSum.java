package leetcodeSlidingWindow;

//Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
//
//A subarray is a contiguous part of the array.

public class BInarySubarraysWithSum {
	class Solution {

		int helper(int[] nums, int k) {
			int res = 0;
			int sum = 0;
			int left = 0;

			for (int i = 0; i < nums.length; i++) {

				sum += nums[i];

				while (left <= i && sum > k) {
					sum -= nums[left];
					left++;
				}
				res += i - left + 1;
			}

			return res;

		}

		// calculate the subarrays with sum at most == goal. So we get all subarrays
		// with sum <= goal
		// then calculate subarrays with sum <= goal-1
		// subtract them so we are left with only the subarrays with sum == goal
		public int numSubarraysWithSum(int[] nums, int k) {

			return helper(nums, k) - helper(nums, k - 1);

		}
	}
}
