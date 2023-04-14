package leetcodeSlidingWindow;

//The score of an array is defined as the product of its sum and its length.
//
//For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
//Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose score is strictly less than k.
//
//A subarray is a contiguous sequence of elements within an array.

public class CountSubarraysWithScoreLessThanK {

	// basic sliding window
	// for each subarray move window and go on checking whether the subarray is
	// valid or not
	public long countSubarrays(int[] nums, long k) {
		long ans = 0;
		int left = 0, right = 0;
		int n = nums.length;

		long sum = 0;
		while (right < n) {
			sum += nums[right];
			while (left <= right && checkprod(left, right, sum, k) == false) {
				sum -= nums[left];
				left++;
			}
			if (left <= right)
				ans += right - left + 1;

			right++;
		}

		return ans;
	}

	boolean checkprod(int left, int right, long sum, long k) {
		long temp = (long) (sum * (right - left + 1));
		return temp < k ? true : false;
	}

}
