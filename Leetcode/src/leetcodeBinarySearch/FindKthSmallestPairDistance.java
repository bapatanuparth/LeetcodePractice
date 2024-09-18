package leetcodeBinarySearch;

import java.util.Arrays;

//The distance of a pair of integers a and b is defined as the absolute difference between a and b.
//
//Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

public class FindKthSmallestPairDistance {

	public int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums[nums.length - 1] - nums[0];

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int pairs = findSmaller(nums, mid);
			if (pairs < k)
				left = mid + 1;
			else
				right = mid - 1;
		}

		return left;
	}

	int findSmaller(int nums[], int x) {
		int cnt = 0, n = nums.length;
		for (int i = 0, j = 0; i < n; i++) {
			while (j < n && nums[j] <= nums[i] + x)
				j++;
			cnt += j - i - 1;
		}
		return cnt;
	}

}
