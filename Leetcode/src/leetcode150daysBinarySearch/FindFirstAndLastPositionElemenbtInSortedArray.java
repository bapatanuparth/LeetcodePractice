package leetcode150daysBinarySearch;

//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.

public class FindFirstAndLastPositionElemenbtInSortedArray {

	public int[] searchRange(int[] nums, int target) {
		int mid = nums.length / 2;
		int left = 0, right = nums.length - 1;

		if (nums.length == 0)
			return new int[] { -1, -1 };

		int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] == target) {
				if (mid != 0 && nums[mid - 1] == target)
					right = mid - 1;
				else {
					min = mid;
					break;
				}
			} else if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}

		left = 0;
		right = nums.length - 1;
		mid = nums.length / 2;

		while (left <= right) {
			mid = (left + right) / 2;
			if (nums[mid] == target) {

				if (mid != (nums.length - 1) && nums[mid + 1] == target)

					left = mid + 1;

				else {
					max = mid;
					break;
				}
			} else if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}

		if (min == Integer.MAX_VALUE)
			return new int[] { -1, -1 };

		return new int[] { min, max };
	}

}
