package leetcodeBinarySearch;

import java.util.Arrays;

//You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.
//
//Notice that x does not have to be an element in nums.
//
//Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.

public class Leetcode1608 {

	public int specialArray(int[] nums) {
		Arrays.sort(nums);
		int max = nums[nums.length - 1];
		int n = nums.length;

		for (int i = max; i >= 0; i--) {
			int location = findNum(nums, i);
			if (n - (location + 1) == i)
				return i;
		}
		return -1;
	}

	int findNum(int[] nums, int num) {
		int left = 0, right = nums.length - 1;
		int ans = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < num) {
				ans = mid;
				left = mid + 1;
			} else
				right = mid - 1;
		}

		return ans;
	}

}
