package leetcode150daysBinarySearch;

//A peak element is an element that is strictly greater than its neighbors.
//
//Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
//
//You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
//
//You must write an algorithm that runs in O(log n) time.

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;

		int n = nums.length;
		if (n == 1)
			return 0;
		while (left <= right) {
			int mid = (left + right) / 2;

			if (mid == 0) {
				if (nums[mid + 1] > nums[mid]) {
					left = mid + 1;
				} else
					return 0;
			} else if (mid == (n - 1)) {
				if (nums[mid - 1] > nums[mid]) {
					right = mid - 1;
				} else
					return n - 1;
			} else {
				if (nums[mid - 1] > nums[mid])
					right = mid - 1;
				else if (nums[mid + 1] > nums[mid])
					left = mid + 1;
				else {
					return mid;
				}
			}
		}

		return -1;
	}

}
